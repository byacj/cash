package com.korea.credit.payment.model;

import com.korea.credit.payment.enums.CardCorporation;
import com.korea.credit.payment.enums.PaymentDetailStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author sungjun
 * @since 9/3/24
 */
@Setter
@Getter
public class PaymentDetail {
    private long id;

    private String userId;

    private long mallNo;

    private PaymentDetailStatus status;

    private LocalDateTime paymentAt;

    private CardCorporation cardCorporation;

    private CardCorporation partnershipCardCorporation;

    private String cardNo;

    private String approvalNo;

    private BigDecimal paymentAmt;

    private int monthlyInstallmentPlan;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    public com.korea.credit.payment.entities.PaymentDetail toEntity() {
        com.korea.credit.payment.entities.PaymentDetail entity = new com.korea.credit.payment.entities.PaymentDetail();

        entity.setId(this.id);
        entity.setUserId(this.userId);
        entity.setMallNo(this.mallNo);
        entity.setStatus(this.status);
        entity.setPaymentAt(this.paymentAt);
        entity.setCardCorporation(this.cardCorporation);
        entity.setPartnershipCardCorporation(this.partnershipCardCorporation);
        entity.setCardNo(this.cardNo);
        entity.setApprovalNo(this.approvalNo);
        entity.setPaymentAmt(this.paymentAmt);
        entity.setMonthlyInstallmentPlan(this.monthlyInstallmentPlan);
        entity.setCreatedAt(this.createdAt);
        entity.setCreatedBy(this.createdBy);
        entity.setUpdatedAt(this.updatedAt);
        entity.setUpdatedBy(this.updatedBy);

        return entity;
    }
}