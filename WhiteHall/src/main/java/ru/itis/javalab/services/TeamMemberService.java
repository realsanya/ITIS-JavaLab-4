package ru.itis.javalab.services;

import ru.itis.javalab.models.TeamMember;

import java.util.List;

public interface TeamMemberService {
    List<TeamMember> getAllMembers();
//    List<TeamMember> getAllMembers(int page, int size);
    List<TeamMember> getMembersByName(String name);
    List<TeamMember> getMembersByRole(String role);
}
