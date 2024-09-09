package com.korea.credit.payment.model;

import com.korea.credit.payment.entities.PaymentDetail;
import com.korea.credit.payment.enums.CardCorporation;
import com.korea.credit.payment.enums.PaymentDetailStatus;
import com.korea.credit.utils.SchedulerUtils;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author sungjun
 * @since 9/9/24
 */
@Getter
@Setter
public class PaymentMessage {
    private long id;

    private String userId;

    private long mallNo;

    private PaymentDetailStatus status;

    private String paymentAt;

    private CardCorporation cardCorporation;

    private CardCorporation partnershipCardCorporation;

    private String cardNo;

    private String approvalNo;

    private BigDecimal paymentAmt;

    private int monthlyInstallmentPlan;

    private String createdAt;

    private String createdBy;

    private String updatedAt;

    private String updatedBy;

    public static PaymentMessage fromEntity(PaymentDetail paymentDetail) {
        PaymentMessage message = new PaymentMessage();
        message.setId(paymentDetail.getId());
        message.setUserId(paymentDetail.getUserId());
        message.setMallNo(paymentDetail.getMallNo());
        message.setStatus(paymentDetail.getStatus());
        message.setPaymentAt(SchedulerUtils.localDateTimeToStr(paymentDetail.getPaymentAt()));
        message.setCardCorporation(paymentDetail.getCardCorporation());
        message.setPartnershipCardCorporation(paymentDetail.getPartnershipCardCorporation());
        message.setCardNo(paymentDetail.getCardNo());
        message.setApprovalNo(paymentDetail.getApprovalNo());
        message.setPaymentAmt(paymentDetail.getPaymentAmt());
        message.setMonthlyInstallmentPlan(paymentDetail.getMonthlyInstallmentPlan());
        message.setCreatedAt(SchedulerUtils.localDateTimeToStr(paymentDetail.getCreatedAt()));
        message.setCreatedBy(paymentDetail.getCreatedBy());
        message.setUpdatedAt(SchedulerUtils.localDateTimeToStr(paymentDetail.getUpdatedAt()));
        message.setUpdatedBy(paymentDetail.getUpdatedBy());
        return message;
    }
}
