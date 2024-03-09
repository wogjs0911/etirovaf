package com.etirovaf.backend.member.infrastructure.repository;

import com.etirovaf.backend.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface MemberRepository extends JpaRepository<Member, UUID>, MemberRepositoryCustom {
}
