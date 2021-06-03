package ru.itis.javalab.redis.services.interfaces;

import ru.itis.javalab.redis.dto.TokenDto;
import ru.itis.javalab.redis.models.Token;

import java.util.Optional;

public interface TokenService {
    Optional<TokenDto> findByToken(String token);
    Token createRefreshToken(Long userId);
}
