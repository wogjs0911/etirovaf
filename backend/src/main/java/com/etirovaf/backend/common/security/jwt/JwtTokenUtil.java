package com.etirovaf.backend.common.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private final SecretKey secretKey;
    private final long accessTokenValiditySeconds;

    // JWT Token 발급
    public JwtTokenUtil(
            @Value("${jwt.secretKey}") final String secretKey,
            @Value("${jwt.token-validity-in-seconds}") final long accessTokenValiditySeconds
    ){
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public String createAccessToken(Long usereId){
        return createToken(usereId, accessTokenValiditySeconds);
    }

    private String createToken(Long usereId, long validitySeconds){
        // Claim -> Jwt Token에 들어갈 정보 -> Claim에 loginId를 넣어줌
        Claims claims = Jwts.claims();
        claims.put("memberId", usereId);

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime tokenValidity = now.plusSeconds(validitySeconds);

        return Jwts.builder()
                .setClaims(claims)  // token에 넣을 클레임(정보) 설정
                .setIssuedAt(Date.from(now.toInstant()))    // 토큰 발급 시간
                .setExpiration(Date.from(tokenValidity.toInstant()))    // 토큰 만료 시간
                .signWith(secretKey, SignatureAlgorithm.HS256)  // 토큰 서명 설정
                .compact(); // 문자열로 압축
    }

    // Claims에서 userId 추출
    public Long getUserId(String token){
        return getClaims(token).getBody()
                .get("userId", Long.class);
    }

    // 발급된 Token의 만료시간 초과 여부
    public boolean isExpired(String token){
        try {
            Jws<Claims> claims = getClaims(token);
            Date expiredDate = claims.getBody()
                    .getExpiration();
            Date now = new Date();
            return expiredDate.after(now);
        } catch (ExpiredJwtException e) {
            throw new BadCredentialsException("JWT token has expired", e);
        } catch (SecurityException
                | MalformedJwtException
                | UnsupportedJwtException
                | IllegalArgumentException e) {
            throw new BadCredentialsException("Error validating JWT token", e);
        }
    }

    // SecretKey를 사용해 Token Parsing
    private Jws<Claims> getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }

}
