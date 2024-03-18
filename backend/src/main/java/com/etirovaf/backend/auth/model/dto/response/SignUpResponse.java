package com.etirovaf.backend.auth.model.dto.response;

import lombok.*;

@Data
@Builder
public class SignUpResponse {
    private String accessToken;

    public static SignUpResponse of(String accessToken) {
        return SignUpResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
