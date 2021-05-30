package ru.itis.javalab.redis.dto;

import lombok.*;
import ru.itis.javalab.redis.models.Teacher;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;

    public static TeacherDto from(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();
    }

    public static List<TeacherDto> from(List<Teacher> teachers) {
        return teachers.stream().map(TeacherDto::from).collect(Collectors.toList());
    }
}
