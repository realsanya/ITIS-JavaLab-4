package ru.itis.javalab.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    private Integer id;
    private String type;
    private String path;
}
