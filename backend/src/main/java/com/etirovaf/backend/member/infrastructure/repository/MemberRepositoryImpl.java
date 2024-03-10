package com.etirovaf.backend.member.infrastructure.repository;

import com.etirovaf.backend.member.model.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.etirovaf.backend.member.model.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findByUserId(String userId) {
        return Optional.ofNullable(queryFactory
                .select(member)
                .from(member)
                .where(member.userId.eq(userId))
                .fetchOne());
    }
}
