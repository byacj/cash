package com.korea.credit.payment.entities;

import com.korea.credit.payment.enums.CardCorporation;
import com.korea.credit.payment.enums.PaymentDetailStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "payment_detail")
@Entity
@Setter
@Getter
public class PaymentDetail {
    @Id
    private long id;

    private String userId;

    private long mallNo;

    @Enumerated(value = EnumType.STRING)
    private PaymentDetailStatus status;

    private LocalDateTime paymentAt;

    @Enumerated(value = EnumType.STRING)
    private CardCorporation cardCorporation;

    @Enumerated(value = EnumType.STRING)
    private CardCorporation partnershipCardCorporation;

    private String cardNo;

    private String approvalNo;

    private BigDecimal paymentAmt;

    private int monthlyInstallmentPlan;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}