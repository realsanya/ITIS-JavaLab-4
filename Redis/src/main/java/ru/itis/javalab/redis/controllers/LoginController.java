package ru.itis.javalab.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.javalab.redis.dto.EmailPasswordDto;
import ru.itis.javalab.redis.dto.RefreshTokenDto;
import ru.itis.javalab.redis.dto.TokenDto;
import ru.itis.javalab.redis.services.interfaces.LoginService;
import ru.itis.javalab.redis.services.interfaces.TokenService;

import java.util.Optional;

@RestController
public class LoginController {

    private final LoginService loginService;
    private final TokenService tokenService;

    @Autowired
    public LoginController(LoginService loginService, TokenService tokenService) {
        this.loginService = loginService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmailPasswordDto emailPassword) throws Throwable {
        Optional<TokenDto> tokenDto = loginService.login(emailPassword);
        if (tokenDto.isPresent()) {
            return ResponseEntity.ok(tokenDto.get());
        }
        return ResponseEntity.status(403).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDto request) {
        String requestRefreshToken = request.getRefresh();
        return ResponseEntity.ok(tokenService.findByToken(requestRefreshToken)
                .orElseThrow(() -> new IllegalStateException(requestRefreshToken + " is not in database!")));
    }
}
