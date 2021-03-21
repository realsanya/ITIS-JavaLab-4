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
    private Long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String text;

    public static TeamMemberDto from(TeamMember member) {
        if (member == null) {
            return null;
        }
        return TeamMemberDto.builder()
                .id(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .role(member.getRoleId())
                .text(member.getText())
                .build();
    }

    public static List<TeamMemberDto> from(List<TeamMember> members) {
        return members.stream()
                .map(TeamMemberDto::from)
                .collect(Collectors.toList());
    }

}
