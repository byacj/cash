package com.korea.credit.transfer.service;

import com.korea.credit.common.CashConstants;
import com.korea.credit.transfer.entities.TransferMessage;
import com.korea.credit.transfer.entities.TransferMessageHistory;
import com.korea.credit.transfer.enums.TransferStatus;
import com.korea.credit.transfer.enums.TransferType;
import com.korea.credit.transfer.repositories.TransferMessageHistoryRepository;
import com.korea.credit.transfer.repositories.TransferMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author sungjun
 * @since 9/8/24
 */
@RequiredArgsConstructor
@Service
public class TransferMessageService {
    private final TransferMessageRepository transferMessageRepository;
    private final TransferMessageHistoryRepository transferMessageHistoryRepository;

    @Transactional
    public void registerTransferPaymentDetail(String userId, long mallNo) {
        Optional<TransferMessage> optional = transferMessageRepository.findByUserIdAndMallNoAndTypeAndUse(userId, mallNo, TransferType.PAYMENT, true);
        TransferMessage transferMessage;
        if (optional.isEmpty()) {
            transferMessage = new TransferMessage();
            transferMessage.setUserId(userId);
            transferMessage.setMallNo(mallNo);
            transferMessage.setType(TransferType.PAYMENT);
            transferMessage.setUse(true);
            transferMessage.setCreatedAt(LocalDateTime.now());
            transferMessage.setCreatedBy(CashConstants.SYSTEM);
            transferMessage.setUpdatedAt(LocalDateTime.now());
            transferMessage.setUpdatedBy(CashConstants.SYSTEM);
            transferMessageRepository.save(transferMessage);
        } else {
            transferMessage = optional.get();
        }

        Optional<TransferMessageHistory> transferMessageHistoryOptional =
                transferMessageHistoryRepository.findByUserIdAndMallNoAndTransferMessageIdAndProceedEndDate(userId, mallNo, transferMessage.getId(), LocalDate.now());
        if (transferMessageHistoryOptional.isEmpty()) {
            TransferMessageHistory transferMessageHistory = new TransferMessageHistory();
            transferMessageHistory.setUserId(userId);
            transferMessageHistory.setMallNo(mallNo);
            transferMessageHistory.setTransferMessageId(transferMessage.getId());
            transferMessageHistory.setPeriod(180);
            transferMessageHistory.setProceedEndDate(LocalDate.now());
            transferMessageHistory.setType(TransferType.PAYMENT);
            transferMessageHistory.setStatus(TransferStatus.REQUEST);
            transferMessageHistory.setCreatedAt(LocalDateTime.now());
            transferMessageHistory.setCreatedBy(CashConstants.SYSTEM);
            transferMessageHistory.setUpdatedAt(LocalDateTime.now());
            transferMessageHistory.setUpdatedBy(CashConstants.SYSTEM);
            transferMessageHistoryRepository.save(transferMessageHistory);
        }
    }
}
