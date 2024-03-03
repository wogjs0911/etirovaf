package com.etirovaf.backend.member.repository;

import com.etirovaf.backend.member.model.entity.Member;

public interface MemberRepositoryCustom {
    Member findByUsername(String userName);
}
