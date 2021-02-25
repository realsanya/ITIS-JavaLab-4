package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.Role;
import ru.itis.javalab.models.TeamMember;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMemberDto {
    private Integer id;
    private String first_name;
    private String last_name;
    private Role role;
    private String text;

    public static TeamMemberDto from(TeamMember member) {
        if (member == null) {
            return null;
        }
        return TeamMemberDto.builder()
                .id(member.getId())
                .first_name(member.getFirst_name())
                .last_name(member.getLast_name())
                .role(member.getRole_id())
                .text(member.getText())
                .build();
    }

    public static List<TeamMemberDto> from(List<TeamMember> members) {
        return members.stream()
                .map(TeamMemberDto::from)
                .collect(Collectors.toList());
    }

}
