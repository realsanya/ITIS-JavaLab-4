package ru.itis.javalab.redis.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.dto.EmailPasswordDto;
import ru.itis.javalab.redis.dto.TokenDto;
import ru.itis.javalab.redis.models.User;
import ru.itis.javalab.redis.redis.services.RedisUsersService;
import ru.itis.javalab.redis.repositories.UsersRepository;
import ru.itis.javalab.redis.services.interfaces.LoginService;

import java.time.LocalDateTime;
import java.util.function.Supplier;

@Service
public class LoginServiceImpl implements LoginService {

    private final Algorithm algorithm;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisUsersService redisUsersService;

    @Autowired
    public LoginServiceImpl(Algorithm algorithm, UsersRepository usersRepository, PasswordEncoder passwordEncoder, RedisUsersService redisUsersService) {
        this.algorithm = algorithm;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.redisUsersService = redisUsersService;
    }

    @Override
    public TokenDto login(EmailPasswordDto emailPassword) throws Throwable {
        User user = usersRepository.findByEmail(emailPassword.getEmail())
                .orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("User not found"));
        System.out.println(user);
        if (passwordEncoder.matches(emailPassword.getPassword(), user.getHashPassword())) {
            String token = JWT.create()
                    .withSubject(user.getId().toString())
                    .withClaim("role", user.getRole().toString())
                    .withClaim("state", user.getState().toString())
                    .withClaim("email", user.getEmail())
                    .withClaim("createdAt", LocalDateTime.now().toString())
                    .sign(algorithm);
            redisUsersService.addTokenToUser(user, token);
            return TokenDto.builder()
                    .token(token)
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
