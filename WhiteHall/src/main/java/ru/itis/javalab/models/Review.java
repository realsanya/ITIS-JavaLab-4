package ru.itis.javalab.models;

import java.sql.Date;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    private Integer id;
    private User user_id;
    private Date date;
    private String text;
}
