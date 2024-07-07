/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 7
 */

package com.dxc.loginApp.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.dxc.loginApp.security.CustomAuthenticationFailureHandler;
import com.dxc.loginApp.security.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

    //Using in-built memory for user details.
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder().encode("userPass"))
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("manager")
                .password(passwordEncoder().encode("managerPass"))
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity _http) throws Exception {
        _http.authorizeHttpRequests((requests) -> requests.requestMatchers("/manager/**")
                .hasRole("MANAGER")
                .requestMatchers("/anonymous*")
                .anonymous()
                .requestMatchers("/login*")
                .permitAll()
                .requestMatchers("/h2-console")
                .permitAll()
                .anyRequest()
                .authenticated()
        ).formLogin((form) -> form.loginPage("/login.html")
                .permitAll()
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/homepage.html", true)
                .failureUrl("/login.html?error=true")
                .failureHandler(authenticationFailureHandler())
        ).logout((logout) -> logout.permitAll()
                // .logoutUrl("/perfrom_logout")
                .logoutSuccessUrl("/login.html?logout=true")
                .deleteCookies("JSESSIONID")
                // .logoutSuccessHandler(logoutSuccessHandler())
        );
        
        return _http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
}