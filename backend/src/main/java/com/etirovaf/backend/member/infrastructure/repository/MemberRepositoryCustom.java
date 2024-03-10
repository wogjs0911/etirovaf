package com.etirovaf.backend.member.infrastructure.repository;

import com.etirovaf.backend.member.model.entity.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findByUserId(String userId);
}
