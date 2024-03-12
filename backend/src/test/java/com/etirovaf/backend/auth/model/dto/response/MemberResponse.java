package com.etirovaf.backend.auth.model.dto.response;

import lombok.*;

public class MemberResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LoginResponse {
        String accessToken;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SignUpResponse {
        String accessToken;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberInfoResponse {
        String userId;
        String nickname;
        String name;
    }
}
