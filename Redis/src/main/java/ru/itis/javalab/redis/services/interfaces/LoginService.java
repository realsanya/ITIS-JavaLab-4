package ru.itis.javalab.redis.services.interfaces;

import ru.itis.javalab.redis.dto.EmailPasswordDto;
import ru.itis.javalab.redis.dto.TokenDto;

import java.util.Optional;

public interface LoginService {
    Optional<TokenDto> login(EmailPasswordDto emailPassword) throws Throwable;
}
