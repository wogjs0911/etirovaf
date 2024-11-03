package com.etirovaf.backend.dream.infrastructure.repository;

import com.etirovaf.backend.dream.model.entity.Dream;

import java.util.Optional;

public interface DreamRepositoryCustom {
    Optional<Dream> findDreamById(Long id);
    Optional<Dream> findDreamByTitle(String title);
}
