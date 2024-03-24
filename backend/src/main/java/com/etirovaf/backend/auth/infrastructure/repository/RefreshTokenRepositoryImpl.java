package com.etirovaf.backend.auth.infrastructure.repository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {
    private final RedisTemplate<String, String> redisTemplate;
    private final Long refreshTokenValiditySeconds;

    public RefreshTokenRepositoryImpl(final RedisTemplate<String, String> redisTemplate,
                                      @Value("${jwt.refresh-token-validity-in-seconds}") final long refreshTokenValiditySeconds){
        this.redisTemplate = redisTemplate;
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    @Override
    public void save(String refreshToken, String userId) {
        final long liveTimeBySeconds = refreshTokenValiditySeconds / 1000;
        redisTemplate.opsForValue()
                .set(refreshToken, "JWT_REFRESH_TOKEN:" + userId, liveTimeBySeconds, TimeUnit.SECONDS);
    }

    @Override
    public Optional<String> findMemberIdByRefreshToken(String refreshToken) {
        String userId = redisTemplate.opsForValue().get(refreshToken);
        if(userId == null) {
            return Optional.empty();
        }
        return Optional.of(userId);
    }
}
