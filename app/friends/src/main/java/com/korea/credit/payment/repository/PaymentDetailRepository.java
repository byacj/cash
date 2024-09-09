package com.korea.credit.payment.repository;

import com.korea.credit.payment.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sungjun
 * @since 9/9/24
 */
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
}
