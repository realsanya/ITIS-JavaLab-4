package ru.itis.javalab.redis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.javalab.redis.dto.TokenDto;
import ru.itis.javalab.redis.models.Token;
import ru.itis.javalab.redis.models.User;
import ru.itis.javalab.redis.repositories.TokenRepository;
import ru.itis.javalab.redis.repositories.UsersRepository;
import ru.itis.javalab.redis.services.interfaces.TokenService;
import ru.itis.javalab.redis.utils.JwtGenerator;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${jwt.refreshExpiration}")
    private Long refreshExpiration;

    private final TokenRepository tokenRepository;
    private final JwtGenerator jwtGenerator;
    private final UsersRepository usersRepository;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository, JwtGenerator jwtGenerator, UsersRepository usersRepository) {
        this.tokenRepository = tokenRepository;
        this.jwtGenerator = jwtGenerator;
        this.usersRepository = usersRepository;
    }

    @Override
    public Optional<TokenDto> findByToken(String token) {
        Optional<Token> refreshToken = tokenRepository.findByToken(token);
        if (refreshToken.isPresent() && expirationIsValid(refreshToken.get())) {
            User user = refreshToken.get().getUser();

            String newToken = jwtGenerator.generateToken(user);
            return Optional.of(TokenDto.builder()
                    .access(newToken)
                    .refresh(token)
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Token createRefreshToken(Long userId) {
        Token refreshToken = new Token();

        refreshToken.setUser(usersRepository.findById(userId).get());
        refreshToken.setDateExpired(Instant.now().plusMillis(refreshExpiration));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = tokenRepository.save(refreshToken);
        return refreshToken;
    }

    public boolean expirationIsValid(Token token) {
        if (token.getDateExpired().compareTo(Instant.now()) < 0) {
            tokenRepository.delete(token);
            throw new IllegalStateException(token.getToken() + " isn't valid");
        }

        return true;
    }

}
