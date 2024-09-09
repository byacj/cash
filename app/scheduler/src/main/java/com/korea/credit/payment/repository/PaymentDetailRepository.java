package com.korea.credit.payment.repository;

import com.korea.credit.payment.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sungjun
 * @since 9/3/24
 */
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
    List<PaymentDetail> findByUserIdAndMallNoAndPaymentAtBetween(String userId, long mallNo, LocalDateTime startAt, LocalDateTime endAt);
}
