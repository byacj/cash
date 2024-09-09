package com.korea.credit.transfer.entities;

import com.korea.credit.transfer.enums.TransferStatus;
import com.korea.credit.transfer.enums.TransferType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author sungjun
 * @since 9/8/24
 */
@Getter
@Setter
@Table(name = "transfer_message_history")
@Entity
public class TransferMessageHistory {
    @Id
    private long id;

    private String userId;

    private long mallNo;

    private long transferMessageId;

    private int period;

    private LocalDate proceedEndDate;

    @Enumerated(value = EnumType.STRING)
    private TransferStatus status;

    @Enumerated(value = EnumType.STRING)
    private TransferType type;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    public static TransferMessageHistory nextTransferMessageHistory(TransferMessageHistory transferMessageHistory) {
        TransferMessageHistory nextHistory = new TransferMessageHistory();
        nextHistory.setUserId(transferMessageHistory.getUserId());
        nextHistory.setMallNo(transferMessageHistory.getMallNo());
        nextHistory.setTransferMessageId(transferMessageHistory.getTransferMessageId());
        nextHistory.setPeriod(1); // 전일치만 가져오도록 설정.
        nextHistory.setProceedEndDate(transferMessageHistory.getProceedEndDate().plusDays(1));
        nextHistory.setStatus(TransferStatus.REQUEST);
        nextHistory.setType(TransferType.PAYMENT);
        nextHistory.setCreatedAt(LocalDateTime.now());
        nextHistory.setCreatedBy("SYSTEM");
        nextHistory.setUpdatedAt(LocalDateTime.now());
        nextHistory.setUpdatedBy("SYSTEM");

        return nextHistory;
    }
}
