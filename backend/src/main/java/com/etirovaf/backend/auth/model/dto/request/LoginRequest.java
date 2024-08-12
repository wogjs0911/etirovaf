package com.etirovaf.backend.auth.model.dto.request;

import com.etirovaf.backend.member.model.entity.Member;
import lombok.*;

@Data
@Builder
public class LoginRequest {
    private String identifier;
    private String password;

    public static LoginRequest of(Member entity) {
        return LoginRequest.builder()
                .identifier(entity.getIdentifier())
                .password(entity.getPassword())
                .build();
    }
}
