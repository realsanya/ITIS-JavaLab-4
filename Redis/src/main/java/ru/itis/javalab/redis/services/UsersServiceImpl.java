package ru.itis.javalab.redis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.models.User;
import ru.itis.javalab.redis.redis.services.RedisUsersService;
import ru.itis.javalab.redis.repositories.UsersRepository;
import ru.itis.javalab.redis.services.interfaces.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RedisUsersService redisUsersService;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, RedisUsersService redisUsersService) {
        this.usersRepository = usersRepository;
        this.redisUsersService = redisUsersService;
    }

    @Override
    public void blockUser(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        redisUsersService.addAllTokensToBlackList(user);
    }
}
