package com.etirovaf.backend.dream.presentation;

import com.etirovaf.backend.common.exception.ServiceException;
import com.etirovaf.backend.dream.application.DreamService;
import com.etirovaf.backend.dream.model.dto.request.DreamInfoRequest;
import com.etirovaf.backend.dream.model.entity.HashtagEntity;
import com.etirovaf.backend.member.model.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dream")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "03.드림목록")
public class DreamController {
    private final DreamService service;

    @GetMapping("/add")
    @Operation(summary="꿈 관련 글 작성", description = "뀸 관련 글을 목록에 저장한다.", tags={"03.드림목록",})
//    public boolean addDream(@RequestBody DreamInfoRequest dreamInfoRequest){
    public boolean addDream() throws ServiceException {
        log.info("addDream");

        Member member = new Member();
        member.setUserId("wogjs0911@example.com");

        List<HashtagEntity> hashtag = new ArrayList<>();
        hashtag.add(new HashtagEntity("서강대"));
        hashtag.add(new HashtagEntity("정문"));
        hashtag.add(new HashtagEntity("법"));

//        return service.addDream(dreamInfoRequest);
        return service.addDream(DreamInfoRequest.builder()
                .title("서강대에서 법 관련 공부할 사람?")
                .place("서강대 정문")
                .content("dreamContent")
                .hashtag(hashtag)
                .member(member)
                .build());
    }
}
