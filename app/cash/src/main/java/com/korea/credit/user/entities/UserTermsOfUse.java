package com.korea.credit.user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author sungjun
 * @since 9/5/24
 */
@Table(name = "user_terms_of_use")
@Entity
@Setter
@Getter
public class UserTermsOfUse {
    @Id
    private long id;

    private String userId;

    private LocalDateTime simpleConnectionAgreeAt;

    private LocalDateTime provideDataAgreeAt;

    public boolean isAgreeSimpleConnectionAgreeAt() {
        return simpleConnectionAgreeAt != null;
    }
}
