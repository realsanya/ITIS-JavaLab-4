package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
