package com.korea.credit.user.service;

import com.korea.credit.common.exceptions.BadRequest;
import com.korea.credit.common.exceptions.RegisterTransferPaymentFailByFriendsException;
import com.korea.credit.transfer.service.TransferMessageService;
import com.korea.credit.user.UserTestFixture;
import com.korea.credit.user.entities.User;
import com.korea.credit.user.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

/**
 * @author sungjun
 * @since 9/9/24
 */
//@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private TransferMessageService transferMessageService;

    @Mock
    private UserValidateService userValidateService;

    @Mock
    private UserTermsOfUseCommandService userTermsOfUseCommandService;

    @Mock
    private UserCommunicateFriendsService userCommunicateFriendsService;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUser_정상() {
        doReturn(Optional.of(UserTestFixture.USER)).when(userRepository).findByBusinessNo(UserTestFixture.BUSINESS_NO);
        User result = userService.getUser(UserTestFixture.BUSINESS_NO);
        assertThat(result.getUserId()).isEqualTo( UserTestFixture.USER.getUserId());
    }

    @Test()
    public void testGetUser_유저가_없을_때() {
        doReturn(Optional.empty()).when(userRepository).findByBusinessNo(UserTestFixture.BUSINESS_NO);
        Assertions.assertThrows(BadRequest.class, () -> userService.getUser(UserTestFixture.BUSINESS_NO));
    }

    @Test
    public void testCommunicateRegisterDataCommunication_friends_등록오류() {
        doReturn(Optional.of(UserTestFixture.USER)).when(userRepository).findByBusinessNo(UserTestFixture.BUSINESS_NO);
        doThrow(RegisterTransferPaymentFailByFriendsException.class).when(userCommunicateFriendsService).registerDataCommunication(UserTestFixture.BUSINESS_NO);
        Assertions.assertThrows(RegisterTransferPaymentFailByFriendsException.class, () -> userService.requestPaymentsTransmission(UserTestFixture.BUSINESS_NO));
    }





}
