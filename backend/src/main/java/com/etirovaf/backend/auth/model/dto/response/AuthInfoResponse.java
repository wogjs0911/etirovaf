package com.etirovaf.backend.auth.model.dto.response;

import com.etirovaf.backend.member.model.entity.Member;
import lombok.*;

@Data
@Builder
public class AuthInfoResponse {
    private String userId;
    private String nickname;
    private String name;

    public static AuthInfoResponse of(Member entity) {
        return AuthInfoResponse.builder()
                .userId(entity.getUserId())
                .nickname(entity.getNickname())
                .name(entity.getName())
                .build();
    }
}
