package ru.itis.javalab.redis.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {
    private String access;
    private String refresh;
}
