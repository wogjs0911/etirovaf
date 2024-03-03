package com.etirovaf.backend.member.model.dto;

import com.etirovaf.backend.member.model.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberInfo {
    private String username;
    private String nickname;
    private String password;
    private Role role;
}
