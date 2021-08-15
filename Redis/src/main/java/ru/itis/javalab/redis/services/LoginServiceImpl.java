package ru.itis.javalab.redis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.dto.EmailPasswordDto;
import ru.itis.javalab.redis.dto.TokenDto;
import ru.itis.javalab.redis.models.Token;
import ru.itis.javalab.redis.models.User;
import ru.itis.javalab.redis.redis.services.RedisUsersService;
import ru.itis.javalab.redis.repositories.TokenRepository;
import ru.itis.javalab.redis.repositories.UsersRepository;
import ru.itis.javalab.redis.services.interfaces.LoginService;
import ru.itis.javalab.redis.services.interfaces.TokenService;
import ru.itis.javalab.redis.utils.JwtGenerator;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final JwtGenerator jwtGenerator;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisUsersService redisUsersService;
    private final TokenRepository tokenRepository;
    private final TokenService tokenService;

    @Autowired
    public LoginServiceImpl(JwtGenerator jwtGenerator, UsersRepository usersRepository, PasswordEncoder passwordEncoder, RedisUsersService redisUsersService, TokenRepository tokenRepository, TokenService tokenService) {
        this.jwtGenerator = jwtGenerator;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.redisUsersService = redisUsersService;
        this.tokenRepository = tokenRepository;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<TokenDto> login(EmailPasswordDto emailPassword) throws Throwable {
        Optional<User> user = usersRepository.findByEmail(emailPassword.getEmail());

        if (user.isPresent() && passwordEncoder.matches(emailPassword.getPassword(), user.get().getHashPassword())) {
            Token refreshToken = tokenService.createRefreshToken(user.get().getId());

            String token = jwtGenerator.generateToken(user.get());
            System.out.println(token);
            redisUsersService.addTokenToUser(user.get(), token);

            return Optional.of(TokenDto.builder()
                    .access(token)
                    .refresh(refreshToken.getToken())
                    .build());
        }
        return Optional.empty();
    }

}
