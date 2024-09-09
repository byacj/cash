package com.korea.credit.payment.controller;

import com.korea.credit.payment.service.PaymentDetailService;
import com.korea.credit.transfer.enums.TransferType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sungjun
 * @since 9/8/24
 */
@RequiredArgsConstructor
@RequestMapping("payments")
@RestController
public class PaymentController {
    private final PaymentDetailService paymentDetailService;

    @PostMapping("/transfer")
    public void transfer() {
        paymentDetailService.transfer(List.of(TransferType.PAYMENT, TransferType.PAYMENT_INITIAL));
    }
}
