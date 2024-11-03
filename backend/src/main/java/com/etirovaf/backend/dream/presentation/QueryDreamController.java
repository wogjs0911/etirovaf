package com.etirovaf.backend.dream.presentation;

import com.etirovaf.backend.common.domain.ResponseHandler;
import com.etirovaf.backend.dream.application.DreamService;
import com.etirovaf.backend.dream.model.entity.Dream;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dream")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "03.꿈")
public class QueryDreamController {
    private final DreamService service;

    @GetMapping("/{id}")
    @Operation(summary="꿈 관련 글 단건 조회", description = "꿈 관련 게시글 한 건을 조회한다.", tags={"03.꿈",})
    public ResponseEntity<ResponseHandler<Dream>> getDream(
            @PathVariable Long id){
        log.info("getDreamByTitle");
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<Dream>builder()
                        .message("SUCCESS")
                        .data(service.getDream(id))
                        .build()
                );
    }


    @GetMapping
    @Operation(summary="꿈 관련 글 제목으로 검색", description = "꿈 관련 게시글 한 건을 제목으로 검색한다.", tags={"03.꿈",})
    public ResponseEntity<ResponseHandler<Dream>> getDreamByTitle(@RequestParam String title){
        log.info("getDreamByTitle");
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<Dream>builder()
                        .message("SUCCESS")
                        .data(service.getDreamByTitle(title))
                        .build()
                );
    }

    @GetMapping("/list")
    @Operation(summary="꿈 관련 전체 글 목록 조회", description = "꿈 관련 글 전체 목록을 조회한다.", tags={"03.꿈",})
    public ResponseEntity<ResponseHandler<List<Dream>>> getDreamList(){
        log.info("getAllDreamList");
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<List<Dream>>builder()
                        .message("SUCCESS")
                        .data(service.getAllDreamList())
                        .build()
                );
    }
}
