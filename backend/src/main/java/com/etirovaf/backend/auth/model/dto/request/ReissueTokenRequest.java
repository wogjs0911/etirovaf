package com.etirovaf.backend.auth.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReissueTokenRequest {
    private String refreshToken;

    public static ReissueTokenRequest of(String refreshToken) {
        return ReissueTokenRequest.builder()
                .refreshToken(refreshToken)
                .build();
    }
}
