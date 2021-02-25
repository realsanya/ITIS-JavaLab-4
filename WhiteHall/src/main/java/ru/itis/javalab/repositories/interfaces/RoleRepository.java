package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
