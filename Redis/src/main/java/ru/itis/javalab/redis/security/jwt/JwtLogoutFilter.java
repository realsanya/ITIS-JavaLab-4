package ru.itis.javalab.redis.security.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.javalab.redis.services.interfaces.JwtBlacklistService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtLogoutFilter extends OncePerRequestFilter {

    private final JwtBlacklistService service;

    private final RequestMatcher logoutRequest = new AntPathRequestMatcher("/logout", "GET");

    public JwtLogoutFilter(JwtBlacklistService service) {
        this.service = service;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (logoutRequest.matches(httpServletRequest)) {
            service.add(httpServletRequest.getHeader("Authorization"));
            SecurityContextHolder.clearContext();
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
