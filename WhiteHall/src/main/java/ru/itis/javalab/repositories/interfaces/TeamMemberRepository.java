package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.Role;
import ru.itis.javalab.models.TeamMember;

import java.util.List;

public interface TeamMemberRepository extends CrudRepository<TeamMember, Integer> {
    List<TeamMember> getAllByRole(Role role);
    List<TeamMember> findAll(int page, int size);
    List<TeamMember> findMembersByName(String name);
    List<TeamMember> findMembersByRole(String role);
}
