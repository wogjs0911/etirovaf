package com.etirovaf.backend.dream.application;

import com.etirovaf.backend.common.exception.ServiceException;
import com.etirovaf.backend.dream.infrastructure.repository.DreamRepository;
import com.etirovaf.backend.dream.model.dto.request.DreamInfoRequest;
import com.etirovaf.backend.dream.model.entity.Dream;
import com.etirovaf.backend.member.application.MemberService;
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

    public boolean addDream(DreamInfoRequest dreamInfoRequest) throws ServiceException {
//        Optional<Member> member = memberService.getMemberByIdentifier(dreamInfoRequest.getCreator().getIdentifier());
//        if(member.isEmpty())
//            throw new ServiceException(ResultCode.VALID_NOT_NULL);
//        dreamInfoRequest.setCreator(member.get());
        repository.save(Dream.saveDream(dreamInfoRequest));
        return true;
    }
}
