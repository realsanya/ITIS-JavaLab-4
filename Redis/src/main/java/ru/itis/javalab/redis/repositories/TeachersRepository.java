package ru.itis.javalab.redis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.redis.models.Teacher;

import java.util.List;

public interface TeachersRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByIsDeletedIsNull();
}
