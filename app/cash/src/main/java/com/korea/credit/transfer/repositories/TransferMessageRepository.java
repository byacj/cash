package com.korea.credit.transfer.repositories;

import com.korea.credit.transfer.entities.TransferMessage;
import com.korea.credit.transfer.enums.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author sungjun
 * @since 9/8/24
 */
public interface TransferMessageRepository extends JpaRepository<TransferMessage, Long> {
    Optional<TransferMessage> findByUserIdAndMallNoAndTypeAndUse(String userId, long mallNo, TransferType type, boolean use);
}
