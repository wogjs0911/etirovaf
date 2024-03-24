package com.etirovaf.backend.auth.model.dto.response;

import lombok.*;

@Data
@Builder
public class LoginResponse {
    private String accessToken;
    private String refreshToken;

    public static LoginResponse of(String accessToken, String refreshToken) {
        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
