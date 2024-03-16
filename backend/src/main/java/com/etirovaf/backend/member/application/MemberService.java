package com.etirovaf.backend.member.application;

import com.etirovaf.backend.member.model.dto.request.MemberInfo;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.infrastructure.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public boolean addMember(MemberInfo memberInfo) {
        repository.save(Member.of(memberInfo));
        return true;
    }

    public Optional<Member> getMemberByUserId(String username) {
        return repository.findByUserId(username);
    }
}
