package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.Image;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {
    private Integer id;
    private String type;
    private String path;

    public static ImageDto from(Image image) {
        if (image == null) {
            return null;
        }
        return ImageDto.builder()
                .id(image.getId())
                .type(image.getType())
                .path(image.getPath())
                .build();
    }

    public static List<ImageDto> from(List<Image> images) {
        return images.stream()
                .map(ImageDto::from)
                .collect(Collectors.toList());
    }
}
