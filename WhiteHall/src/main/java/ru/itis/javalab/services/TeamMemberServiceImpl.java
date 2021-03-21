package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.models.Role;
import ru.itis.javalab.models.TeamMember;
import ru.itis.javalab.repositories.RoleRepository;
import ru.itis.javalab.repositories.TeamMemberRepository;

import java.util.List;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private TeamMemberRepository teamMemberRepository;
    private RoleRepository roleRepository;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository, RoleRepository roleRepository) {
        this.teamMemberRepository = teamMemberRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<TeamMember> getAllMembers() {
        return teamMemberRepository.findAll();
    }

    @Override
    public List<TeamMember> getMembersByName(String name) {
        return teamMemberRepository.findMembersByFirstName(name);
    }

    @Override
    public List<TeamMember> getMembersByRole(String name) {
        Role role = roleRepository.findByName(name);
        return teamMemberRepository.findAllByRoleId(role);
    }
}
