package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.Hall;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HallDto {
    private Long id;
    private String name;
    private Integer cost;

    public static HallDto from(Hall hall) {
        if (hall == null) {
            return null;
        }
        return HallDto.builder()
                .id(hall.getId())
                .name(hall.getName())
                .cost(hall.getCost())
                .build();
    }

    public static List<HallDto> from(List<Hall> halls) {
        return halls.stream()
                .map(HallDto::from)
                .collect(Collectors.toList());
    }
}
