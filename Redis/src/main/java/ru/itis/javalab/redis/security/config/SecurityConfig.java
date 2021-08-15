package ru.itis.javalab.redis.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import ru.itis.javalab.redis.security.jwt.JwtAuthenticationFilter;
import ru.itis.javalab.redis.security.jwt.JwtAuthenticationProvider;
import ru.itis.javalab.redis.security.jwt.JwtLogoutFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtLogoutFilter jwtLogoutFilter;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, JwtLogoutFilter jwtLogoutFilter, JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtLogoutFilter = jwtLogoutFilter;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(jwtLogoutFilter, LogoutFilter.class)
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/teachers").hasAuthority("ADMIN")
                .antMatchers("/logout").hasAnyAuthority()
                .and()
                .sessionManagement().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
}
