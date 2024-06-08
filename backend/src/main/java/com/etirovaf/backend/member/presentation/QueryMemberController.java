package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.common.domain.ResponseHandler;
import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "02.회원")
public class QueryMemberController {

    private final MemberService service;

    @GetMapping
    @Operation(summary="회원정보", description = "회원정보를 받아온다.", tags={"02.회원",})
    public ResponseEntity<ResponseHandler<Optional<Member>>> getMember(@RequestParam String identifier){
        log.info("getMemberByUsername");
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<Optional<Member>>builder()
                        .message("SUCCESS")
                        .data(service.getMemberByIdentifier(identifier))
                        .build()
                );
    }
}
