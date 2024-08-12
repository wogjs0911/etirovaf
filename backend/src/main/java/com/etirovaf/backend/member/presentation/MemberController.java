package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.member.model.dto.request.SignupRequest;
import com.etirovaf.backend.common.domain.ResponseHandler;
import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.entity.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "02.회원")
public class MemberController {
    private final MemberService service;

    @PostMapping("/add")
    @Operation(summary="회원가입", description = "회원을 목록에 저장한다.", tags={"02.회원",})
    public ResponseEntity<ResponseHandler<Boolean>> addMember(@RequestBody SignupRequest signupRequest){
        log.info("addMember");
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<Boolean>builder()
                        .message("회원가입 성공")
                        .data(service.addMember(signupRequest))
                        .build()
                );
    }
}