package com.etirovaf.backend.common.security.jwt;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {   // OncePerRequestFilter -> 한 번의 요청에 한 번만 실행되도록 보장
    private final CustomUserDetailService customUserDetailService;
    private final JwtTokenUtil jwtTokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Http 헤더에서 Authorization 값 가져오기
        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            // 토큰을 가져와서 그 토큰을 디코딩하여 회원정보를 뽑아서 이용한다.
            String token = authorizationHeader.substring(7);

            if(jwtTokenUtil.isExpired(token)){
                String userId = jwtTokenUtil.getUserId(token);
                UserDetails userDetails = customUserDetailService.loadUserByUsername(userId);

                // 첫번쩨 매개변수 : userDetails
                // 두번째 매개변수 : 패스워드, 사용 안해서 null로
                // 세번째 매개변수 : 사용자 권한 정보를 나타내는 SimpleGrantedAuthority 객체 생성, 이를 리스트로 묶어서 토큰에 설정
                // loginMember.getRole().name()은 멤버의 Role을 문자열로 가져와서 해당 역할 부여
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                throw new EntityNotFoundException("해당하는 회원이 없습니다.");
            }
        } else {
            throw new BadCredentialsException("유효하지 않은 토큰입니다.");
        }
        filterChain.doFilter(request, response);
    }
}
