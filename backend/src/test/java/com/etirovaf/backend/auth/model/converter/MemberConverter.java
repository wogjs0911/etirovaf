package com.etirovaf.backend.auth.model.converter;

import com.etirovaf.backend.auth.model.dto.request.MemberRequest;
import com.etirovaf.backend.auth.model.dto.response.MemberResponse;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;

public class MemberConverter {

    public static Member toMember(MemberRequest.SignUpRequest request, String encodedPassword) {
        return Member.builder()
                .userId(request.getUserId())
                .password(encodedPassword)
                .nickname(request.getNickname())
                .name(request.getName())
                .role(Role.MEMBER)
                .build();
    }

    public static MemberResponse.MemberInfoResponse memberInfoResponse(Member member) {
        return MemberResponse.MemberInfoResponse.builder()
                .userId(member.getUserId())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }
}
