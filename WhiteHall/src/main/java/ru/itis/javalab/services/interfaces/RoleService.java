package ru.itis.javalab.services.interfaces;

import ru.itis.javalab.dto.RoleDto;
import ru.itis.javalab.models.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();

    RoleDto getRoleByName(String name);

    void addRole(Role role);

    //TODO посмотреть как передавать RoleDto в Repository
    Role getRole(Integer id);
}
