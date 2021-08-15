package ru.itis.javalab.redis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.redis.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
