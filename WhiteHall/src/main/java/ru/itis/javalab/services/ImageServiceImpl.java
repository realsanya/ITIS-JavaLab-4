package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.models.Image;
import ru.itis.javalab.repositories.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image getImageByPath(String path) {
        return imageRepository.findImageByPath(path);
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findImageById(id);
    }

    @Override
    public void addImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(Image image) {
        imageRepository.delete(image);
    }

}
