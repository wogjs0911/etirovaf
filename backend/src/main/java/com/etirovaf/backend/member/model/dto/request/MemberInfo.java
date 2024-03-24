package com.etirovaf.backend.member.model.dto.request;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;
import lombok.*;

@Data
@Builder
public class MemberInfo {
    private String userId;
    private String nickname;
    private String password;
    private String name;
    private Role role;

    public static MemberInfo of(Member entity){
        return MemberInfo.builder()
                .userId(entity.getUserId())
                .build();
    }
}
