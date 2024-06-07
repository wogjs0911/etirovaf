package com.etirovaf.backend.auth.application;

import com.etirovaf.backend.auth.infrastructure.repository.RefreshTokenRepository;
import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.auth.model.dto.request.ReissueTokenRequest;
import com.etirovaf.backend.auth.model.dto.request.SignupRequest;
import com.etirovaf.backend.auth.model.dto.response.LoginResponse;
import com.etirovaf.backend.auth.model.dto.response.SignupResponse;
import com.etirovaf.backend.common.exception.ResultCode;
import com.etirovaf.backend.common.exception.ServiceException;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final RedisTemplate<String, Object> redisTemplate;
    private final RefreshTokenRepository refreshTokenRepository;

    // 회원가입
    /**
     * TODO : 유효성 검증 추가 후 반환 타입 boolean으로 변경하기!
     */
    @Transactional
    public boolean addMember(SignupRequest request) {
        SignupRequest signUpRequest = SignupRequest.toMember(request, encoder.encode(request.getPassword()));
        memberRepository.save(Member.saveMember(signUpRequest));
        makeAuthenticationBySingupResponse(request);
        return true;
    }

    // 로그인
    /**
     * TODO : 유효성 검증 추가 후 반환 타입 boolean으로 변경하기!
     */
    @Transactional
    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByIdentifier(request.getIdentifier())
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원은 없습니다."));

        if(!encoder.matches(request.getPassword(), member.getPassword())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
        return makeAuthenticationByLoginResponse(request);
    }

    // 로그아웃
    /**
     * TODO : 유효성 검증 추가 후 반환 타입 boolean으로 변경하기!
     */
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

    public SignupResponse reissueToken(ReissueTokenRequest reissueTokenRequest) throws ServiceException {
        checkTokenValid(reissueTokenRequest.getRefreshToken());
        String memberId = findIdentifierByRefreshToken(reissueTokenRequest.getRefreshToken());
        Member member = findMemberByRefreshToken(memberId);
        return makeAuthenticationBySingupResponse(SignupRequest.of(member));
    }

    private void checkTokenValid(String refreshToken) throws ServiceException {
        if(!jwtTokenUtil.isExpired(refreshToken))
            throw new ServiceException(ResultCode.REFRESH_TOKEN_EXPIRED);
    }

    /**
     * 회원가입 시, RefreshToken DB에 저장
     * @param refreshToken
     * @param signUpRequest
     */
    private void saveRefreshTokenBySignup(String refreshToken, SignupRequest signUpRequest){
        refreshTokenRepository.save(refreshToken, signUpRequest.getIdentifier());
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
     * 회원가입 시, refreshToken, accessToken 생성
     * @param signUpRequest
     */
    private SignupResponse makeAuthenticationBySingupResponse(SignupRequest signUpRequest){
        String refreshToken = jwtTokenUtil.createRefreshToken(signUpRequest.getIdentifier());
        saveRefreshTokenBySignup(refreshToken, signUpRequest);
        String accessToken = jwtTokenUtil.createAccessToken(signUpRequest.getIdentifier());
        redisTemplate.opsForValue().set("JWT_ACCESS_TOKEN:" + signUpRequest.getIdentifier(), accessToken);
        System.out.printf("refreshToken: %s, accessToken : : %s\n\n", refreshToken, accessToken);
        return SignupResponse.of(refreshToken, accessToken);
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
    private String findIdentifierByRefreshToken(String clientRefreshToken) throws ServiceException {
        return refreshTokenRepository.findIdentifierByRefreshToken(clientRefreshToken)
                .orElseThrow(() -> new ServiceException(ResultCode.REFRESH_TOKEN_EXPIRED));
    }

    private Member findMemberByRefreshToken(String identifier) throws ServiceException {
        Member member = new Member();
        member.setIdentifier(identifier);
        return memberRepository.findByIdentifier(member.getIdentifier())
                .orElseThrow(() -> new ServiceException(ResultCode.MEMBER_NOT_EXIST));
    }
}
