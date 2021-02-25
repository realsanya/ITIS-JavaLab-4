package ru.itis.javalab.services.interfaces;

import ru.itis.javalab.dto.TeamMemberDto;
import ru.itis.javalab.models.TeamMember;

import java.util.List;

public interface TeamMemberService {
    List<TeamMember> getAllMembers();
    List<TeamMember> getAllMembers(int page, int size);
    List<TeamMember> getMembersByName(String name);
    List<TeamMember> getMembersByRole(String role);
    void addUser(TeamMemberDto memberDto);

    TeamMemberDto getMember(Integer memberId);
}
