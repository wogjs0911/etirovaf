package com.etirovaf.backend.dream.application;

import com.etirovaf.backend.common.exception.ResultCode;
import com.etirovaf.backend.common.exception.ServiceException;
import com.etirovaf.backend.dream.infrastructure.repository.DreamRepository;
import com.etirovaf.backend.dream.model.dto.request.DreamInfoRequest;
import com.etirovaf.backend.dream.model.entity.Dream;
import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DreamService {
    private final MemberService memberService;
    private final DreamRepository repository;

    public Dream getDreamByTitle(String title) {
        return repository.findDreamByTitle(title)
                .orElseThrow(() -> new ServiceException(ResultCode.VALID_NOT_NULL));
    }

    public List<Dream> getAllDreamList() {
        List<Dream> dreamList = repository.findAll();
        if (dreamList.isEmpty()) {
            throw new ServiceException(ResultCode.VALID_NOT_NULL);
        }
        return dreamList;
    }

    @Transactional
    public boolean createDream(DreamInfoRequest dreamInfoRequest, String identifier) {
        Member member = memberService.getMemberByIdentifier(identifier);
        DreamInfoRequest updateDreamInfoRequest = DreamInfoRequest.withMember(dreamInfoRequest, member);
        repository.save(Dream.saveDream(updateDreamInfoRequest));
        return true;
    }
}
