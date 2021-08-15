package ru.itis.javalab.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.javalab.redis.dto.TeacherDto;
import ru.itis.javalab.redis.services.interfaces.TeachersService;

import java.util.List;

@RestController
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDto>> getTeachers() {
        return ResponseEntity.ok(teachersService.getAllTeachers());
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(teachersService.addTeacher(teacher));
    }
}
