package com.korea.credit.user.service;

import com.korea.credit.common.exceptions.BadRequest;
import com.korea.credit.common.exceptions.RegisterTransferPaymentFailByFriendsException;
import com.korea.credit.transfer.service.TransferMessageService;
import com.korea.credit.user.entities.User;
import com.korea.credit.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sungjun
 * @since 9/8/24
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TransferMessageService transferMessageService;
    private final UserValidateService userValidateService;
    private final UserTermsOfUseCommandService userTermsOfUseCommandService;
    private final UserCommunicateFriendsService userCommunicateFriendsService;

    @Transactional
    public void agreeSimpleConnection(String clientId) {
        User user = getUser(clientId);
        userTermsOfUseCommandService.agreeSimpleConnectionAgreeAt(user.getUserId());
    }


    @Transactional
    public void requestPaymentsTransmission(String clientId) {
        User user = getUser(clientId);
        userValidateService.validatePaymentsTransmission(clientId, user.getUserId());

        long dummyMallNo = 1; //조건에서 몰번호를 가져올 수 있는 방법이 없음.
        userTermsOfUseCommandService.agreeProvideData(user.getUserId());
        transferMessageService.registerTransferPaymentDetail(user.getUserId(), dummyMallNo);
        userCommunicateFriendsService.registerDataCommunication(clientId);
    }

    public User getUser(String clientId) {
        return userRepository.findByBusinessNo(clientId).orElseThrow(
                () -> new BadRequest("NOT EXIST USER. clientId : " + clientId)
        );
    }
}
