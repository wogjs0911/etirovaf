package com.etirovaf.backend.member.repository;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.etirovaf.backend.member.model.entity.QMember.member;


@Repository
public class MemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    // 이게 편하다.
    public MemberRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Integer save(Member member){
        em.persist(member);
        return 1;
    }

    public List<Member> findByUsername(String username){
        return queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq(username))
                .fetch();
    }



}
