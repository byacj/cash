package com.korea.credit.payment.service;

import com.korea.credit.payment.model.PaymentDetail;
import com.korea.credit.payment.repository.PaymentDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sungjun
 * @since 9/9/24
 */
@RequiredArgsConstructor
@Service
public class PaymentDetailService {
    private final PaymentDetailRepository paymentDetailRepository;

    public void registerPaymentDetail(List<PaymentDetail> paymentDetails) {
        paymentDetails.stream().map(PaymentDetail::toEntity).forEach(
                paymentDetailRepository::save
        );
    }

}
