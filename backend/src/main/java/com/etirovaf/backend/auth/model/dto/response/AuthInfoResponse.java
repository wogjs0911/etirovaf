package com.etirovaf.backend.auth.model.dto.response;

import com.etirovaf.backend.member.model.entity.Member;
import lombok.*;

@Data
@Builder
public class AuthInfoResponse {
    private String identifier;
    private String nickname;
    private String name;

    public static AuthInfoResponse of(Member entity) {
        return AuthInfoResponse.builder()
                .identifier(entity.getIdentifier())
                .nickname(entity.getNickname())
                .name(entity.getName())
                .build();
    }
}
