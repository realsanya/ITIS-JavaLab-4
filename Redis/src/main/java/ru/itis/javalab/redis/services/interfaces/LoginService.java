package ru.itis.javalab.redis.services.interfaces;

import ru.itis.javalab.redis.dto.EmailPasswordDto;
import ru.itis.javalab.redis.dto.TokenDto;

public interface LoginService {
    TokenDto login(EmailPasswordDto emailPassword) throws Throwable;
}
