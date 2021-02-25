package ru.itis.javalab.services.interfaces;

import ru.itis.javalab.dto.ImageDto;
import ru.itis.javalab.models.Image;

import java.util.List;

public interface ImageService {
    Image getImageByPath(String path);

    List<ImageDto> getAllImages();

    Image getImage(Integer id);

    void addImage(Image image);

    void deleteImage(ImageDto image);

}
