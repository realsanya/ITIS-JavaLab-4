package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.Role;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto {
    private Integer id;
    private String name;

    public static RoleDto from(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDto.builder()
                .id(role.getRoleId())
                .name(role.getName())
                .build();
    }

    public static List<RoleDto> from(List<Role> roles) {
        return roles.stream()
                .map(RoleDto::from)
                .collect(Collectors.toList());
    }
}
