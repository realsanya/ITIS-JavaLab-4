package ru.itis.javalab.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMember {
    private Integer id;
    private String first_name;
    private String last_name;
    private Role role_id;
    private String text;

}
