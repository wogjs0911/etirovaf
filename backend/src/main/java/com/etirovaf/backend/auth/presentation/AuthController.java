package com.etirovaf.backend.auth.presentation;

import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.auth.model.dto.request.ReissueTokenRequest;
import com.etirovaf.backend.auth.model.dto.response.LoginResponse;
import com.etirovaf.backend.auth.model.dto.response.SignupResponse;
import com.etirovaf.backend.auth.application.AuthService;
import com.etirovaf.backend.common.domain.ResponseHandler;
import com.etirovaf.backend.common.exception.ServiceException;
import com.etirovaf.backend.member.model.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name="01.로그인", description = "로그인 기능: 인증 관련")
public class AuthController {

    private final AuthService service;

    @Operation(summary = "로그인", description = "로그인 정보를 이용하여 로그인을 실행한다.", tags={"02.회원",})
    @PostMapping("/login")
    public ResponseEntity<ResponseHandler<LoginResponse>> login(@RequestBody Member member){
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<LoginResponse>builder()
                        .message("로그인 성공")
                        .data(service.login(LoginRequest.of(member)))
                        .build()
                );
    }

    @Operation(summary = "Refresh 토큰 재발급")
    @PostMapping("/reissue")
    public ResponseEntity<ResponseHandler<LoginResponse>> reissue(@RequestBody ReissueTokenRequest reissueTokenRequest) throws ServiceException {
        LoginResponse loginResponse = service.reissueToken(reissueTokenRequest);
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<LoginResponse>builder()
                        .message("Refresh 토큰 재발급")
                        .data(loginResponse)
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
