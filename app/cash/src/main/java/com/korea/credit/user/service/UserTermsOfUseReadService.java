package com.korea.credit.user.service;

import com.korea.credit.common.exceptions.BadRequest;
import com.korea.credit.user.entities.UserTermsOfUse;
import com.korea.credit.user.repositories.UserTermsOfUseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author sungjun
 * @since 9/8/24
 */
@RequiredArgsConstructor
@Service
public class UserTermsOfUseReadService {
    private final UserTermsOfUseRepository userTermsOfUseRepository;

    public UserTermsOfUse getUserTermsOfUse(String userId) {
        return userTermsOfUseRepository.findByUserId(userId).orElseThrow(
                () -> new BadRequest("NOT EXIST USER TERMS OF USE. userId = " + userId)
        );
    }
}
