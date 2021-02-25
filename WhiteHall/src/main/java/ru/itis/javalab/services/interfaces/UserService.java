package ru.itis.javalab.services.interfaces;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    boolean userIsExist(String email);

    void addUser(User user);

    User getUser(String email);

    User getUserById(Integer id);
}
