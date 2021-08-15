package ru.itis.javalab.models;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "method")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer count;

    public Method(String name) {
        this.name = name;
        this.count = 0;
    }
}
