package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.Image;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    Image findByPath(String path);

    void update(Image image);
}
