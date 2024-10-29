package com.etirovaf.backend.dream.application;

import com.etirovaf.backend.dream.infrastructure.repository.DreamRepository;
import com.etirovaf.backend.dream.model.dto.request.DreamInfoRequest;
import com.etirovaf.backend.dream.model.entity.Dream;
import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DreamService {
    private final MemberService memberService;
    private final DreamRepository repository;

    public Optional<Dream> getDreamByTitle(String title) {
        return repository.findDreamByTitle(title);
    }

    public List<Dream> getAllDreamList() {
        return repository.findAll();
    }

    public boolean createDream(DreamInfoRequest dreamInfoRequest) {
        Member member = memberService.getMemberByIdentifier(dreamInfoRequest.getMember().getIdentifier());
        dreamInfoRequest.setMember(member);
        repository.save(Dream.saveDream(dreamInfoRequest));
        return true;
    }
}
