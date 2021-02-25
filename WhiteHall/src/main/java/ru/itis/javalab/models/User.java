package ru.itis.javalab.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Image image_id;
}
