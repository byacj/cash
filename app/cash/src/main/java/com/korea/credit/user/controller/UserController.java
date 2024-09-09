package com.korea.credit.user.controller;

import com.korea.credit.user.request.SimpleConnectionRequest;
import com.korea.credit.user.request.TransmissionPaymentsRequest;
import com.korea.credit.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author sungjun
 * @since 9/8/24
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/agree/simple-connection")
    public ResponseEntity<Boolean> agreeSimpleConnection(@RequestBody SimpleConnectionRequest request) {
        userService.agreeSimpleConnection(request.getClientId());
        return ResponseEntity.ok(true);
    }

    @PostMapping("/transmission/payments")
    public ResponseEntity<Boolean> requestPaymentTransmission(@RequestBody TransmissionPaymentsRequest request) {
        userService.requestPaymentsTransmission(request.getClientId());
        return ResponseEntity.ok(true);
    }

}
