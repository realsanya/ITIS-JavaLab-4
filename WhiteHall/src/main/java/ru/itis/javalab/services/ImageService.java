package ru.itis.javalab.services;

import ru.itis.javalab.models.Image;

public interface ImageService {
    Image getImageByPath(String path);

    Image getImageById(Long id);

    void addImage(Image image);

    void deleteImage(Image image);
}
