package com.korea.credit.transfer.repositories;

import com.korea.credit.transfer.entities.TransferMessageHistory;
import com.korea.credit.transfer.enums.TransferStatus;
import com.korea.credit.transfer.enums.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author sungjun
 * @since 9/9/24
 */
@Repository
public interface TransferMessageHistoryRepository extends JpaRepository<TransferMessageHistory, Long> {
    List<TransferMessageHistory> findByTypeInAndStatusAndProceedEndDateBefore(List<TransferType> types, TransferStatus status, LocalDate localDate);
}
