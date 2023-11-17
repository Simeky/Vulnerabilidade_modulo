package com.vulnerabilidade.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class securityConfigurations {

  @Autowired
  SecurityFilter securityFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception{

    return  httpsecurity
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
              .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
              .requestMatchers(HttpMethod.POST, "/auth/Add_funcionario").permitAll()
              .requestMatchers(HttpMethod.POST, "/funcionario").hasRole("ADMIN")
              .anyRequest().authenticated())
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();

  }

  @Bean
  public AuthenticationManager authentication_manager(AuthenticationConfiguration authentication_configuration) throws Exception{

    return authentication_configuration.getAuthenticationManager();

  }

  @Bean
  public PasswordEncoder password_encoder(){

    return new BCryptPasswordEncoder();
  }

}
