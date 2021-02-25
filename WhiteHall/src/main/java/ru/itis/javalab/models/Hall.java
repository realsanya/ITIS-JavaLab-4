package ru.itis.javalab.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hall {
    private Integer id;
    private String name;
    private Integer cost;
}
