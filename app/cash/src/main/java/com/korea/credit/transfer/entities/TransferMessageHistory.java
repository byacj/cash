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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
