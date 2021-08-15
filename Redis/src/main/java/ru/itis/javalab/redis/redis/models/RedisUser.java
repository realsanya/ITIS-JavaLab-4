package ru.itis.javalab.redis.redis.models;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("user")
public class RedisUser {
    @Id
    private String id;
    private List<String> tokens;
    private Long userId;
}
