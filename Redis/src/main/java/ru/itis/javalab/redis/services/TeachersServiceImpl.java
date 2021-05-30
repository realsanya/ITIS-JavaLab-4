package ru.itis.javalab.redis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.dto.TeacherDto;
import ru.itis.javalab.redis.models.Teacher;
import ru.itis.javalab.redis.repositories.TeachersRepository;
import ru.itis.javalab.redis.services.interfaces.TeachersService;

import java.util.List;

import static ru.itis.javalab.redis.dto.TeacherDto.from;

@Service
public class TeachersServiceImpl implements TeachersService {

    private final TeachersRepository teachersRepository;

    @Autowired
    public TeachersServiceImpl(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return from(teachersRepository.findAllByIsDeletedIsNull());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacher) {
        Teacher newTeacher = Teacher.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .build();

        teachersRepository.save(newTeacher);
        return from(newTeacher);
    }
}
