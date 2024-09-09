package com.korea.credit.transfer.entities;

import com.korea.credit.transfer.enums.TransferType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author sungjun
 * @since 9/8/24
 */
@Getter
@Setter
@Table(name = "transfer_message")
@Entity
public class TransferMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;

    private long mallNo;

    @Enumerated(value = EnumType.STRING)
    private TransferType type;

    private boolean use;

    private LocalDateTime cancelAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
