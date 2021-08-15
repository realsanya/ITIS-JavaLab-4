package ru.itis.javalab.redis.services.interfaces;

import ru.itis.javalab.redis.dto.TeacherDto;

import java.util.List;

public interface TeachersService {
    List<TeacherDto> getAllTeachers();
    TeacherDto addTeacher(TeacherDto teacher);
}
