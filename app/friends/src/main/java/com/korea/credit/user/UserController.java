package com.korea.credit.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author sungjun
 * @since 9/9/24
 */
@RestController
public class UserController {
    @GetMapping("/has-business")
    public ResponseEntity<Boolean> hasBusiness(@RequestParam("registrationNumber") String registrationNumber) {
        return ResponseEntity.ok(true);
    }

    @PostMapping("/register-data-communication")
    public ResponseEntity<Boolean> registerDataCommunication(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(true);
    }
}
