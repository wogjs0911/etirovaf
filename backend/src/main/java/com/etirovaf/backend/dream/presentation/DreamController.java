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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dream")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "03.드림목록")
public class DreamController {
    private final DreamService service;

    @PostMapping("/reg")
    @Operation(summary="꿈 관련 글 작성", description = "꿈 관련 글을 등록한다.", tags={"03.드림목록",})
    public boolean createDream(@RequestBody DreamInfoRequest dreamInfoRequest) throws ServiceException {
        log.info("createDream");
        return service.createDream(dreamInfoRequest);
    }
}
