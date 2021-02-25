package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.RoleDto;
import ru.itis.javalab.models.Role;
import ru.itis.javalab.repositories.interfaces.RoleRepository;
import ru.itis.javalab.services.interfaces.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return RoleDto.from(roleRepository.findAll());
    }

    @Override
    public RoleDto getRoleByName(String name) {
        return RoleDto.from(roleRepository.findByName(name));
    }


    @Override
    public void addRole(Role role) {
        roleRepository.save(
                Role.builder()
                        .name(role.getName())
                        .build());
    }

    @Override
    public Role getRole(Integer id) {
        return roleRepository.findById(id);
    }
}
