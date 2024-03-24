package com.etirovaf.backend.auth.presentation;

import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.auth.model.dto.request.ReissueTokenRequest;
import com.etirovaf.backend.auth.model.dto.request.SignupRequest;
import com.etirovaf.backend.auth.model.dto.response.LoginResponse;
import com.etirovaf.backend.auth.model.dto.response.SignupResponse;
import com.etirovaf.backend.auth.application.AuthService;
import com.etirovaf.backend.common.domain.ResponseHandler;
import com.etirovaf.backend.common.exception.ServiceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseHandler<SignupResponse>> signup(@RequestBody SignupRequest request){
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<SignupResponse>builder()
                        .message("회원가입 성공")
                        .data(service.signup(request))
                        .build()
                );
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<ResponseHandler<LoginResponse>> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<LoginResponse>builder()
                        .message("로그인 성공")
                        .data(service.login(loginRequest))
                        .build()
                );
    }

    @Operation(summary = "Refresh 토큰 재발급")
    @PostMapping("/reissue")
    public ResponseEntity<ResponseHandler<SignupResponse>> reissue(@RequestBody ReissueTokenRequest reissueTokenRequest) throws ServiceException {
        SignupResponse signupResponse = service.reissueToken(reissueTokenRequest);
        return ResponseEntity
                .ok()
                .body(ResponseHandler.<SignupResponse>builder()
                        .message("Refresh 토큰 재발급")
                        .data(signupResponse)
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
