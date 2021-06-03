package ru.itis.javalab.redis.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.javalab.redis.services.interfaces.JwtBlacklistService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtBlacklistService service;

    @Autowired
    public JwtAuthenticationFilter(JwtBlacklistService service) {
        this.service = service;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("Authorization");

        if (token != null) {
            if (service.exists(token)) {
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return;
            }

            JwtAuthentication tokenAuthentication = new JwtAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
