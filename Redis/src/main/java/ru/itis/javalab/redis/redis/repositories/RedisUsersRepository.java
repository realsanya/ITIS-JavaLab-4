package ru.itis.javalab.redis.redis.repositories;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.itis.javalab.redis.redis.models.RedisUser;

public interface RedisUsersRepository extends KeyValueRepository<RedisUser, String> {
}
