package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Hall;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> findAllByCost(Integer cost);
}
