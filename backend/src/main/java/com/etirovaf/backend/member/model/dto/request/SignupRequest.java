package com.etirovaf.backend.member.model.dto.request;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;
import lombok.*;

@Data
@Builder
public class SignupRequest {
    private Long id;
    private String identifier;
    private String nickname;
    private String password;
    private String name;
    private Role role;

    public static SignupRequest of(Member entity) {
        return SignupRequest.builder()
                .identifier(entity.getIdentifier())
                .nickname(entity.getNickname())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();
    }

    public static SignupRequest toMember(SignupRequest entity, String encodedPassword) {
        return SignupRequest.builder()
                .id(entity.getId())
                .identifier(entity.getIdentifier())
                .password(encodedPassword)
                .nickname(entity.getNickname())
                .role(entity.getRole())
                .build();
    }
}
