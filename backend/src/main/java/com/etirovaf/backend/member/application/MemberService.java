package com.etirovaf.backend.member.application;

import com.etirovaf.backend.member.model.dto.MemberInfo;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public boolean addMember(MemberInfo memberInfo) {
        repository.save(Member.of(memberInfo));
        return true;
    }

    public Member getMemberByUsername(String username) {
        return repository.findByUsername(username);
    }
}
