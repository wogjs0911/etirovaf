package com.etirovaf.backend.auth.model.dto.request;

import com.etirovaf.backend.member.model.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class LoginRequest {
        private String userId;
        private String password;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SignUpRequest {
        private String userId;
        private String nickname;
        private String password;
        private String name;
        private Role role;
    }
}
