package ru.itis.javalab.redis.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.javalab.redis.models.User;
import ru.itis.javalab.redis.security.details.UserDetailsImpl;
import ru.itis.javalab.redis.utils.JwtGenerator;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtGenerator jwtGenerator;

    @Autowired
    public JwtAuthenticationProvider(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthentication jwtAuthentication = (JwtAuthentication)authentication;
        User user = jwtGenerator.getUserFromToken(authentication.getName());
        UserDetails userDetails = new UserDetailsImpl(user);
        jwtAuthentication.setAuthenticated(true);
        jwtAuthentication.setUserDetails(userDetails);
        return jwtAuthentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthentication.class.equals(aClass);
    }
}
