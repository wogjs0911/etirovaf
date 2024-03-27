package com.etirovaf.backend.dream.application;

import com.etirovaf.backend.dream.infrastructure.repository.DreamRepository;
import com.etirovaf.backend.dream.model.entity.Dream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DreamService {
    private final DreamRepository repository;

    public Optional<Dream> getDreamByTitle(String title) {
        return repository.findDreamByTitle(title);
    }

    public List<Dream> getAllDreamList() {
        return repository.findAll();
    }
}
