package com.korea.credit.payment.service;

import com.korea.credit.configurations.ActiveMQConfiguration;
import com.korea.credit.payment.entities.PaymentDetail;
import com.korea.credit.payment.model.PaymentMessage;
import com.korea.credit.payment.repository.PaymentDetailRepository;
import com.korea.credit.transfer.entities.TransferMessageHistory;
import com.korea.credit.transfer.enums.TransferStatus;
import com.korea.credit.transfer.enums.TransferType;
import com.korea.credit.transfer.repositories.TransferMessageHistoryRepository;
import jakarta.jms.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sungjun
 * @since 9/3/24
 */
@RequiredArgsConstructor
@Service
public class PaymentDetailService {

    private static final Logger log = LoggerFactory.getLogger(PaymentDetailService.class);

    private final JmsTemplate jmsTemplate;

    private final PaymentDetailRepository paymentDetailRepository;
    private final TransferMessageHistoryRepository transferMessageHistoryRepository;

    public void transfer(List<TransferType> transferTypes) {
        log.info("===== start transfer");
        LocalDate localDate = LocalDate.now();

        List<TransferMessageHistory> transferMessageHistories =
                transferMessageHistoryRepository.findByTypeInAndStatusAndProceedEndDateBefore(transferTypes, TransferStatus.REQUEST, localDate);

        log.info("process transfer. count: " + transferMessageHistories.size());

        transferMessageHistories.forEach(transferMessageHistory -> {LocalDate endDate = transferMessageHistory.getProceedEndDate();
            LocalDateTime startAt = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 0, 0, 0)
                    .minusDays(transferMessageHistory.getPeriod());
            LocalDateTime endAt = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 0, 0, 0)
                    .plusDays(1);

            List<PaymentDetail> paymentDetails = paymentDetailRepository.findByUserIdAndMallNoAndPaymentAtBetween(transferMessageHistory.getUserId(),
                    transferMessageHistory.getMallNo(), startAt, endAt);

            if (!paymentDetails.isEmpty()) {
                jmsTemplate.convertAndSend(ActiveMQConfiguration.PAYMENTS,
                        paymentDetails.stream().map(PaymentMessage::fromEntity).collect(Collectors.toList()));
            }

            transferMessageHistory.setStatus(TransferStatus.SUCCESS);
            transferMessageHistory.setUpdatedAt(LocalDateTime.now());
            transferMessageHistory.setUpdatedBy("SYSTEM");
            transferMessageHistoryRepository.save(transferMessageHistory);

            transferMessageHistoryRepository.save(
                    TransferMessageHistory.nextTransferMessageHistory(transferMessageHistory));
        });

        log.info("===== end transfer");
    }
}
