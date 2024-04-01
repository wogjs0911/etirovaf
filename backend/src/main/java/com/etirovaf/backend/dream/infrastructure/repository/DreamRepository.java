package com.etirovaf.backend.dream.infrastructure.repository;

import com.etirovaf.backend.dream.model.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DreamRepository extends JpaRepository<Dream, UUID>, DreamRepositoryCustom {
}
