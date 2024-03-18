package com.etirovaf.backend.auth.model.dto.response;

import com.etirovaf.backend.auth.model.dto.request.SignUpRequest;
import com.etirovaf.backend.member.model.entity.Member;
import lombok.*;

@Data
@Builder
public class LoginResponse {
    private String accessToken;

    public static LoginResponse of(String accessToken) {
        return LoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
