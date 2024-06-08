package com.etirovaf.backend.auth.model.dto.response;

import lombok.*;

@Data
@Builder
public class SignupResponse {
    private String accessToken;
    private String refreshToken;

    public static SignupResponse of(String accessToken, String refreshToken) {
        return SignupResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
