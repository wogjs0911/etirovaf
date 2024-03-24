package com.etirovaf.backend.auth.model.dto.request;

import com.etirovaf.backend.member.model.dto.request.MemberInfo;
import com.etirovaf.backend.member.model.entity.Member;
import lombok.*;

@Data
@Builder
public class LoginRequest {
    private String userId;
    private String password;

    public static LoginRequest of(Member entity) {
        return LoginRequest.builder()
                .userId(entity.getUserId())
                .password(entity.getPassword())
                .build();
    }
}
