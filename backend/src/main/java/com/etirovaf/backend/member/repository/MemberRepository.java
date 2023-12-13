package com.etirovaf.backend.member.repository;

import com.etirovaf.backend.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m")
    List<Member> findAll();

}
