package com.etirovaf.backend.member.infrastructure.repository;

import com.etirovaf.backend.member.model.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.etirovaf.backend.member.model.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public Member findByUsername(String username) {
        return (Member) queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq(username))
                .fetchOne();
    }
}
