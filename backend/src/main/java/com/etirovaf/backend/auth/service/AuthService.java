package com.etirovaf.backend.auth.service;

import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.auth.model.dto.request.SignUpRequest;
import com.etirovaf.backend.common.security.jwt.JwtTokenUtil;
import com.etirovaf.backend.member.infrastructure.repository.MemberRepository;
import com.etirovaf.backend.member.model.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final RedisTemplate<String, Object> redisTemplate;

    // 회원가입
    /**
     * TODO : 유효성 검증 추가 후 반환 타입 boolean으로 변경하기!
     */
    public SignUpRequest signup(SignUpRequest request) {
        SignUpRequest signUpRequest = SignUpRequest.toMember(request, encoder.encode(request.getPassword()));
        memberRepository.save(Member.saveMember(signUpRequest));
        String accessToken = jwtTokenUtil.createAccessToken(signUpRequest.getId());
        redisTemplate.opsForValue().set("JWT_TOKEN:" + signUpRequest.getId(), accessToken);

        return signUpRequest;
    }

    // 로그인
    /**
     * TODO : 유효성 검증 추가 후 반환 타입 boolean으로 변경하기!
     */
    public Member login(LoginRequest request) {
        Member member = memberRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원은 없습니다."));

        if(!encoder.matches(request.getPassword(), member.getPassword())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
        String accessToken = jwtTokenUtil.createAccessToken(member.getId());
        redisTemplate.opsForValue().set("JWT_TOKEN:" + member.getId(), accessToken);

        return member;
    }

    // 로그아웃
    /**
     * TODO : 유효성 검증 추가 후 반환 타입 boolean으로 변경하기!
     */
    public String logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // userDetails에서 필요한 정보 추출
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userId = userDetails.getUsername();

            redisTemplate.delete("JWT_TOKE:" + userId);
        }
        return "ok";
    }
}
