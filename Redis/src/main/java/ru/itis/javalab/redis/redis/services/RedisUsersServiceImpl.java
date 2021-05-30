package ru.itis.javalab.redis.redis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.models.User;
import ru.itis.javalab.redis.redis.models.RedisUser;
import ru.itis.javalab.redis.redis.repositories.RedisUsersRepository;
import ru.itis.javalab.redis.repositories.UsersRepository;
import ru.itis.javalab.redis.services.interfaces.JwtBlacklistService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RedisUsersServiceImpl implements RedisUsersService {

    private final UsersRepository usersRepository;
    private final JwtBlacklistService blacklistService;
    private final RedisUsersRepository redisUsersRepository;

    @Autowired
    public RedisUsersServiceImpl(UsersRepository usersRepository, JwtBlacklistService blacklistService, RedisUsersRepository redisUsersRepository) {
        this.usersRepository = usersRepository;
        this.blacklistService = blacklistService;
        this.redisUsersRepository = redisUsersRepository;
    }

    @Override
    public void addTokenToUser(User user, String token) {
        String redisId = user.getRedisId();

        RedisUser redisUser;
        if (redisId != null) {
            redisUser = redisUsersRepository.findById(redisId).orElseThrow(IllegalArgumentException::new);
            if (redisUser.getTokens() == null) {
                redisUser.setTokens(new ArrayList<>());
            }
            redisUser.getTokens().add(token);
        } else {
            redisUser = RedisUser.builder()
                    .userId(user.getId())
                    .tokens(Collections.singletonList(token))
                    .build();
        }
        redisUsersRepository.save(redisUser);
        user.setRedisId(redisUser.getId());
        usersRepository.save(user);
    }

    @Override
    public void addAllTokensToBlackList(User user) {
        if (user.getRedisId() != null) {
            RedisUser redisUser = redisUsersRepository.findById(user.getRedisId())
                    .orElseThrow(IllegalArgumentException::new);

            List<String> tokens = redisUser.getTokens();
            for (String token : tokens) {
                blacklistService.add(token);
            }
            redisUser.getTokens().clear();
            redisUsersRepository.save(redisUser);
        }
    }
}
