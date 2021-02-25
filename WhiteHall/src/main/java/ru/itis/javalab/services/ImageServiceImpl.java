package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.ImageDto;
import ru.itis.javalab.models.Image;
import ru.itis.javalab.repositories.interfaces.ImageRepository;
import ru.itis.javalab.services.interfaces.ImageService;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image getImageByPath(String path) {
        return imageRepository.findByPath(path);
    }

    @Override
    public List<ImageDto> getAllImages() {
        return ImageDto.from(imageRepository.findAll());
    }

    @Override
    public Image getImage(Integer id) {
        return imageRepository.findById(id);
    }

    @Override
    public void addImage(Image image) {
        imageRepository.update(image);
    }

    @Override
    public void deleteImage(ImageDto image) {
        //TODO
    }

}
