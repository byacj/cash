package com.korea.credit.user.service;

import com.korea.credit.common.exceptions.NotFoundBusiness;
import com.korea.credit.common.exceptions.RegisterTransferPaymentFailByFriendsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sungjun
 * @since 9/9/24
 */
@RequiredArgsConstructor
@Service
public class UserCommunicateFriendsService {
    private final RestClient restClient;

    @Value("${friends.host}")
    private String friendsHost;
    private static final String FRIENDS_URL_REGISTER_DATA_COMMUNICATION = "register-data-communication";
    private static final String FRIENDS_URL_HAS_BUSINESS = "has-business";

    public void registerDataCommunication(String clientId) {
        Map<String, Object> body = new HashMap<>();
        body.put("registrationNumber", clientId);
        body.put("agreedType", "Y");

        ResponseEntity<Void> response = restClient.post().uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(friendsHost)
                        .port(8081)
                        .path(FRIENDS_URL_REGISTER_DATA_COMMUNICATION)
                        .build()
                )
                .body(body)
                .retrieve().toBodilessEntity();

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RegisterTransferPaymentFailByFriendsException("REGISTER TRANSFER PAYMENT FAIL. clientId : " + clientId);
        }
    }

    public Boolean hasBusiness(String clientId) {
        ResponseEntity<Boolean> response = restClient.get().uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(friendsHost)
                        .port(8081)
                        .path(FRIENDS_URL_HAS_BUSINESS)
                        .queryParam("registrationNumber", clientId)
                        .build())
                .retrieve()
                .toEntity(Boolean.class);

        if (response.getStatusCode() != HttpStatus.OK || !response.hasBody() ) {
            throw new NotFoundBusiness("HAS-BUSINESS FAIL. clientId : " + clientId);
        }

        return response.getBody();
    }
}
