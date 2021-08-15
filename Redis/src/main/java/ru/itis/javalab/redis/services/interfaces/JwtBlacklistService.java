package ru.itis.javalab.redis.services.interfaces;

public interface JwtBlacklistService {
    void add(String token);
    boolean exists(String token);
}
