package com.etirovaf.backend.auth.infrastructure.repository;

import java.util.Optional;

public interface RefreshTokenRepository {
    void save(String refreshToken, String identifier);
    Optional<String> findIdentifierByRefreshToken(String refreshToken);
}
