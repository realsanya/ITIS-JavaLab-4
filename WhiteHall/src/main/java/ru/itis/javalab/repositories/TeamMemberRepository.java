package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Role;
import ru.itis.javalab.models.TeamMember;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    List<TeamMember> findAllByRoleId(Role role);
    List<TeamMember> findMembersByFirstName(String name);
}
