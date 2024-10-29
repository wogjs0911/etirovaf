package com.etirovaf.backend.auth.application;

import com.etirovaf.backend.auth.infrastructure.repository.RefreshTokenRepository;
import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.auth.model.dto.request.ReissueTokenRequest;
import com.etirovaf.backend.auth.model.dto.response.LoginResponse;
import com.etirovaf.backend.common.exception.ResultCode;
import com.etirovaf.backend.common.exception.ServiceException;
import com.etirovaf.backend.common.security.jwt.JwtTokenUtil;
import com.etirovaf.backend.member.infrastructure.repository.MemberRepository;
import com.etirovaf.backend.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final RedisTemplate<String, Object> redisTemplate;
    private final RefreshTokenRepository refreshTokenRepository;

    // 로그인
    @Transactional
    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByIdentifier(request.getIdentifier())
                .orElseThrow(() -> new ServiceException(ResultCode.MEMBER_NOT_EXIST));

        if(!encoder.matches(request.getPassword(), member.getPassword())){
            throw new ServiceException(ResultCode.VALID_NOT_PASSWORD);
        }
        return makeAuthenticationByLoginResponse(request);
    }

    // 로그아웃
    @Transactional
    public String logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            // userDetails에서 필요한 정보 추출
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String identifier = userDetails.getUsername();

            redisTemplate.delete("JWT_TOKEN:" + identifier);
        }
        return "ok";
    }

    public LoginResponse reissueToken(ReissueTokenRequest reissueTokenRequest) {
        checkTokenValid(reissueTokenRequest.getRefreshToken());
        String memberId = findIdentifierByRefreshToken(reissueTokenRequest.getRefreshToken());
        Member member = findMemberByRefreshToken(memberId);
        return makeAuthenticationByLoginResponse(LoginRequest.of(member));
    }

    private void checkTokenValid(String refreshToken) {
        if(!jwtTokenUtil.isExpired(refreshToken))
            throw new ServiceException(ResultCode.REFRESH_TOKEN_EXPIRED);
    }

    /**
     * 로그인 시, RefreshToken DB에 저장
     * @param refreshToken
     * @param loginRequest
     */
    private void saveRefreshTokenByLogin(String refreshToken, LoginRequest loginRequest){
        refreshTokenRepository.save(refreshToken, loginRequest.getIdentifier());
    }

    /**
     * 로그인 시, refreshToken, accessToken 생성
     * @param loginRequest
     */
    private LoginResponse makeAuthenticationByLoginResponse(LoginRequest loginRequest){
        String refreshToken = jwtTokenUtil.createRefreshToken(loginRequest.getIdentifier());
        saveRefreshTokenByLogin(refreshToken, loginRequest);
        String accessToken = jwtTokenUtil.createAccessToken(loginRequest.getIdentifier());
        redisTemplate.opsForValue().set("JWT_ACCESS_TOKEN:" + loginRequest.getIdentifier(), accessToken);
        return LoginResponse.of(refreshToken, accessToken);
    }

    /**
     * clientRefreshToken 유효성 검증
     * @param clientRefreshToken
     * @return
     * @throws ServiceException
     */
    private String findIdentifierByRefreshToken(String clientRefreshToken) {
        return refreshTokenRepository.findIdentifierByRefreshToken(clientRefreshToken)
                .orElseThrow(() -> new ServiceException(ResultCode.REFRESH_TOKEN_EXPIRED));
    }

    private Member findMemberByRefreshToken(String identifier) {
        Member member = new Member();
        member.setIdentifier(identifier);
        return memberRepository.findByIdentifier(member.getIdentifier())
                .orElseThrow(() -> new ServiceException(ResultCode.MEMBER_NOT_EXIST));
    }

    public String findIdentifierByToken(final String token) {
        return jwtTokenUtil.getIdentifier(token);
    }
}
