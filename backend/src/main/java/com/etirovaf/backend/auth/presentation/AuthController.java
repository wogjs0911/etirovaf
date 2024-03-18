package com.etirovaf.backend.auth.presentation;

import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.auth.model.dto.request.SignUpRequest;
import com.etirovaf.backend.auth.service.AuthService;
import com.etirovaf.backend.common.domain.ResponseHandler;
import com.etirovaf.backend.member.model.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="01.로그인", description = "로그인 기능: 인증 관련")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<ResponseHandler<SignUpRequest>> signup(@RequestBody SignUpRequest request){
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<SignUpRequest>builder()
                        .message("회원가입 성공")
                        .data(service.signup(request))
                        .build()
                );
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<ResponseHandler<Member>> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<Member>builder()
                        .message("로그인 성공")
                        .data(service.login(loginRequest))
                        .build()
                );
    }

    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<ResponseHandler<String>> logout(){
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<String>builder()
                        .message("로그아웃 성공")
                        .data(service.logout())
                        .build()
                );
    }
}
