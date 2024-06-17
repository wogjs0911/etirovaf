package com.etirovaf.backend.member.application;

import com.etirovaf.backend.auth.infrastructure.repository.RefreshTokenRepository;
import com.etirovaf.backend.common.security.jwt.JwtTokenUtil;
import com.etirovaf.backend.member.model.dto.request.SignupRequest;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.infrastructure.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final RedisTemplate<String, Object> redisTemplate;
    private final RefreshTokenRepository refreshTokenRepository;

    // 회원가입
    @Transactional
    public boolean addMember(SignupRequest request) {
        SignupRequest signUpRequest = SignupRequest.toMember(request, encoder.encode(request.getPassword()));
        repository.save(Member.saveMember(signUpRequest));
        makeAuthenticationBySingupResponse(request);
        return true;
    }

    /**
     * 회원가입 시, refreshToken, accessToken 생성
     * @param signUpRequest
     */
    private void makeAuthenticationBySingupResponse(SignupRequest signUpRequest){
        String refreshToken = jwtTokenUtil.createRefreshToken(signUpRequest.getIdentifier());
        saveRefreshTokenBySignup(refreshToken, signUpRequest);
        String accessToken = jwtTokenUtil.createAccessToken(signUpRequest.getIdentifier());
        redisTemplate.opsForValue().set("JWT_ACCESS_TOKEN:" + signUpRequest.getIdentifier(), accessToken);
    }

    /**
     * 회원가입 시, RefreshToken DB에 저장
     * @param refreshToken
     * @param signUpRequest
     */
    private void saveRefreshTokenBySignup(String refreshToken, SignupRequest signUpRequest){
        refreshTokenRepository.save(refreshToken, signUpRequest.getIdentifier());
    }

    public Optional<Member> getMemberByIdentifier(String identifier) {
        return repository.findByIdentifier(identifier);
    }
}
