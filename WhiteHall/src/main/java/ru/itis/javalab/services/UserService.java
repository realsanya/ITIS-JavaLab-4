package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> getUser(String email);

    void save(User user);

    boolean userIsExist(String email);

    List<UserDto> getAllUsers();

    void banAll();

}
