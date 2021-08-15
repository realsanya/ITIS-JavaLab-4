package ru.itis.javalab.redis.redis.services;

import ru.itis.javalab.redis.models.User;

public interface RedisUsersService {
    void addTokenToUser(User user, String token);
    void addAllTokensToBlackList(User user);
}
