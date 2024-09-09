package com.korea.credit.task;

import com.korea.credit.payment.service.PaymentDetailService;
import com.korea.credit.transfer.enums.TransferType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sungjun
 * @since 9/6/24
 */
@Component
@RequiredArgsConstructor
public class TransferPaymentDetailTask {
    private final PaymentDetailService paymentDetailService;


    @Scheduled(cron = "0 0 8 * * *") //매일 오전 8시 실행 - 전일자
    public void dailyTransfer() {
        paymentDetailService.transfer(List.of(TransferType.PAYMENT));
    }

    @Scheduled(cron = "0 0 */1 * * *") //1시간 진행 - 6개월치
    public void HourlyTransfer() {
        paymentDetailService.transfer(List.of(TransferType.PAYMENT_INITIAL));
    }

    @Scheduled(cron = "0 */1 * * * *") //테스트용 매분 실행
    public void testTransfer() {
        paymentDetailService.transfer(List.of(TransferType.PAYMENT, TransferType.PAYMENT_INITIAL));
    }
}
