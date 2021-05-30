package ru.itis.javalab.redis.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.repositories.BlacklistRepository;
import ru.itis.javalab.redis.services.interfaces.JwtBlacklistService;

@Service
public class JwtBlacklistServiceImpl implements JwtBlacklistService {

    private final BlacklistRepository blacklistRepository;

    public JwtBlacklistServiceImpl(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    @Override
    public void add(String token) {
        blacklistRepository.save(token);
    }

    @Override
    public boolean exists(String token) {
        return blacklistRepository.exists(token);
    }
}
