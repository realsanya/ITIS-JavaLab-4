package ru.itis.javalab.redis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.redis.models.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
}
