package com.etirovaf.backend.dream.infrastructure.repository;

import com.etirovaf.backend.dream.model.entity.Dream;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.etirovaf.backend.dream.model.entity.QDream.dream;

@RequiredArgsConstructor
public class DreamRepositoryImpl implements DreamRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    @Override
    public Optional<Dream> findDreamByTitle(String title) {
        return Optional.ofNullable(queryFactory
                .select(dream)
                .from(dream)
                .where(dream.title.eq(title))
                .fetchOne());
    }
}
