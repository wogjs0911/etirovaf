package com.etirovaf.backend.auth.model.dto.request;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;
import lombok.*;

@Data
@Builder
public class SignupRequest {
    private Long id;
    private String userId;
    private String nickname;
    private String password;
    private String name;
    private Role role;

    public static SignupRequest of(Member entity) {
        return SignupRequest.builder()
                .userId(entity.getUserId())
                .nickname(entity.getNickname())
                .password(entity.getPassword())
                .name(entity.getName())
                .role(entity.getRole())
                .build();
    }

    public static SignupRequest toMember(SignupRequest entity, String encodedPassword) {
        return SignupRequest.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .password(encodedPassword)
                .nickname(entity.getNickname())
                .name(entity.getName())
                .role(Role.MEMBER)
                .build();
    }
}
