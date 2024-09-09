package com.korea.credit.payment.listeners;

import com.korea.credit.configurations.ActiveMQConfiguration;
import com.korea.credit.payment.model.PaymentMessage;
import com.korea.credit.payment.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author sungjun
 * @since 9/2/24
 */
@RequiredArgsConstructor
@Component
public class PaymentSubscriber {
    private final PaymentDetailService paymentDetailService;

    private static final Logger log = LoggerFactory.getLogger(PaymentSubscriber.class);

    @JmsListener(destination = ActiveMQConfiguration.PAYMENTS)
    public void receiveCustomer(List<LinkedHashMap<String, Object>> paymentDetails){
        log.info("Receive customer message: " + paymentDetails.size());
        paymentDetailService.registerPaymentDetail(paymentDetails);
    }

}
