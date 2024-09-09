package com.korea.credit.payment.entities;

import com.korea.credit.FriendsUtils;
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
import java.util.LinkedHashMap;
import java.util.Objects;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static PaymentDetail fromMap(LinkedHashMap<String, Object> map) {
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setId((int) map.get("id"));
        paymentDetail.setUserId((String) map.get("userId"));
        paymentDetail.setMallNo((int) map.get("mallNo"));
        paymentDetail.setStatus(PaymentDetailStatus.valueOf((String) map.get("status")));
        paymentDetail.setPaymentAt(FriendsUtils.stringToLocalDateTime((String) map.get("paymentAt")));
        paymentDetail.setCardCorporation(CardCorporation.valueOf((String) map.get("cardCorporation")));

        String partnershipCardCorporation = (String) map.get("partnershipCardCorporation");
        if (Objects.nonNull(partnershipCardCorporation)) {
            paymentDetail.setPartnershipCardCorporation(CardCorporation.valueOf((String) map.get("partnershipCardCorporation")));
        }

        paymentDetail.setCardNo((String) map.get("cardNo"));
        paymentDetail.setApprovalNo((String) map.get("approvalNo"));
        paymentDetail.setPaymentAmt(new BigDecimal((int) map.get("paymentAmt")));
        paymentDetail.setMonthlyInstallmentPlan((int) map.get("monthlyInstallmentPlan"));
        paymentDetail.setCreatedAt(FriendsUtils.stringToLocalDateTime((String) map.get("createdAt")));
        paymentDetail.setCreatedBy((String) map.get("createdBy"));
        paymentDetail.setUpdatedAt(FriendsUtils.stringToLocalDateTime((String) map.get("updatedAt")));
        paymentDetail.setUpdatedBy((String) map.get("updatedBy"));


        return paymentDetail;
    }
}