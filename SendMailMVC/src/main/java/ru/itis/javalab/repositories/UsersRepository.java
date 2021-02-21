package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

public interface UsersRepository {
    boolean save(User user);

}

