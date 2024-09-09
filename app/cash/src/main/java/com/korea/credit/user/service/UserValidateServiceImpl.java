package com.korea.credit.user.service;

import com.korea.credit.common.exceptions.BadRequest;
import com.korea.credit.common.exceptions.NotFoundBusiness;
import com.korea.credit.user.entities.UserTermsOfUse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * @author sungjun
 * @since 9/9/24
 */
@RequiredArgsConstructor
@Service
public class UserValidateServiceImpl implements UserValidateService{
    private final UserTermsOfUseReadService userTermsOfUseReadService;
    private final RestClient restClient;
    private final UserCommunicateFriendsService userCommunicateFriendsService;

    @Value("friends.host")
    private String friendsHost;
    private static final String FRIENDS_URL_HAS_BUSINESS = "has-business";

    @Override
    public void validatePaymentsTransmission(String clientId, String userId) {
        UserTermsOfUse userTermsOfUse = userTermsOfUseReadService.getUserTermsOfUse(userId);
        if (!userTermsOfUse.isAgreeSimpleConnectionAgreeAt()) {
            throw new BadRequest("NEED SimpleConnectionAgree. userId : " + userId);
        }

        boolean hasBusiness = userCommunicateFriendsService.hasBusiness(clientId);
        if (!hasBusiness) {
            throw new NotFoundBusiness("NOT FOUND BUSINESS. clientId : " + clientId);
        }
    }
}
