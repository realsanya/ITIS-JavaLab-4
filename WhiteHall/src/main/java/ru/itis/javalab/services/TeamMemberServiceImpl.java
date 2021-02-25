package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.TeamMemberDto;
import ru.itis.javalab.models.TeamMember;
import ru.itis.javalab.repositories.interfaces.TeamMemberRepository;
import ru.itis.javalab.services.interfaces.TeamMemberService;

import java.util.List;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private TeamMemberRepository teamMemberRepository;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    public List<TeamMember> getAllMembers() {
        return teamMemberRepository.findAll();
    }

    @Override
    public List<TeamMember> getAllMembers(int page, int size) {
        return null;
    }

    @Override
    public List<TeamMember> getMembersByName(String name) {
        return teamMemberRepository.findMembersByName(name);
    }

    @Override
    public List<TeamMember> getMembersByRole(String role) {
        return teamMemberRepository.findMembersByRole(role);
    }


    @Override
    public void addUser(TeamMemberDto memberDto) {
        teamMemberRepository.save(TeamMember.builder()
                .first_name(memberDto.getFirst_name())
                .last_name(memberDto.getLast_name())
                .role_id(memberDto.getRole())
                .text(memberDto.getText())
                .build());
    }

    @Override
    public TeamMemberDto getMember(Integer memberId) {
        return TeamMemberDto.from(teamMemberRepository.findById(memberId));
    }
}
