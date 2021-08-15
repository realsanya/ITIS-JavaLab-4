package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.javalab.models.Method;

@Repository
@Transactional
public interface MethodRepository extends JpaRepository<Method, Long> {
    @Modifying
    @Query(value = "UPDATE method SET count = count + 1 WHERE name = ?1", nativeQuery = true)
    void inc(String methodName);
    Method save(Method method);
    Method findByName(String name);
}
