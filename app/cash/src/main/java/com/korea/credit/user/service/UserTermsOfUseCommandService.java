package com.korea.credit.user.service;

import com.korea.credit.common.exceptions.BadRequest;
import com.korea.credit.user.entities.UserTermsOfUse;
import com.korea.credit.user.repositories.UserTermsOfUseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author sungjun
 * @since 9/8/24
 */
@RequiredArgsConstructor
@Service
public class UserTermsOfUseCommandService {
    private final UserTermsOfUseRepository userTermsOfUseRepository;

    @Transactional
    public void agreeSimpleConnectionAgreeAt(String userId) {
        Optional<UserTermsOfUse> optional = userTermsOfUseRepository.findByUserId(userId);

        UserTermsOfUse userTermsOfUse;
        if (optional.isPresent()) {
            userTermsOfUse = optional.get();
        } else {
            userTermsOfUse = new UserTermsOfUse();
            userTermsOfUse.setUserId(userId);
        }
        userTermsOfUse.setSimpleConnectionAgreeAt(LocalDateTime.now());
        userTermsOfUseRepository.save(userTermsOfUse);
    }

    @Transactional
    public void agreeProvideData(String userId) {
        UserTermsOfUse userTermsOfUse = userTermsOfUseRepository.findByUserId(userId).orElseThrow(
                () -> new BadRequest("NOT EXIST USER TERMS OF USE. userId = " + userId)
        );

        userTermsOfUse.setProvideDataAgreeAt(LocalDateTime.now());
    }
}
