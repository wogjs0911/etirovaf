package com.etirovaf.backend.auth.model.dto.request;

import com.etirovaf.backend.member.model.dto.request.MemberInfo;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;
import lombok.*;

@Data
@Builder
public class SignUpRequest {
    private Long id;
    private String userId;
    private String nickname;
    private String password;
    private String name;
    private Role role;

    public static SignUpRequest of(Member entity) {
        return SignUpRequest.builder()
                .userId(entity.getUserId())
                .nickname(entity.getNickname())
                .password(entity.getPassword())
                .name(entity.getName())
                .role(entity.getRole())
                .build();
    }

    public static SignUpRequest toMember(SignUpRequest entity, String encodedPassword) {
        return SignUpRequest.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .password(encodedPassword)
                .nickname(entity.getNickname())
                .name(entity.getName())
                .role(Role.MEMBER)
                .build();
    }
}
