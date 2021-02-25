package ru.itis.javalab.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    private Integer role_id;
    private String name;
}
