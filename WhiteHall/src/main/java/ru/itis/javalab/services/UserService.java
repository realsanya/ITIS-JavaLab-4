package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.models.User;

@Service
public interface UserService {
    User getUser(String email);

    void save(User user);

    boolean userIsExist(String email);

}
