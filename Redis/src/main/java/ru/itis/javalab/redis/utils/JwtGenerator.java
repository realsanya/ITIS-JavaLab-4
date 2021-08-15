package ru.itis.javalab.redis.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itis.javalab.redis.models.User;

import java.util.Date;

@Component
public class JwtGenerator {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole().toString())
                .setExpiration(new Date((new Date()).getTime() + expiration)).signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public User getUserFromToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        return User.builder()
                .id((long) (Integer) body.get("id"))
                .email((String) body.get("email"))
                .role(User.Role.valueOf((String) body.get("role")))
                .build();
    }
}
