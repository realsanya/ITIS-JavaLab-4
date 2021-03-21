package ru.itis.javalab.services;

import ru.itis.javalab.dto.RoleDto;
import ru.itis.javalab.models.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();
    RoleDto getRoleByName(String name);
}
