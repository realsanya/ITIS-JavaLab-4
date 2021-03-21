package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findImageByPath(String path);
    Image findImageById(Long id);
}
