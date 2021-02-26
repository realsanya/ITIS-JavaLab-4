package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
