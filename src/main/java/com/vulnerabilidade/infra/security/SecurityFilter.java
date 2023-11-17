package com.vulnerabilidade.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vulnerabilidade.repositorios.FuncionarioRepositorio;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

  @Autowired
  TokenService tokenService;

  @Autowired
  FuncionarioRepositorio repositorio;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
      
    var token = this.recover_token(request);
    if(token != null){
      var funcionario_usuario = tokenService.validate_token(token);
      UserDetails funcionario = repositorio.findByFuncionario_usuario(funcionario_usuario);

      var authentication = new UsernamePasswordAuthenticationToken(funcionario, null, funcionario.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);

    }
    filterChain.doFilter(request, response);

  }

  private String recover_token(HttpServletRequest request){

    var auth_header = request.getHeader("Authorization");

    if(auth_header == null) return null;
    return auth_header.replace("Bearer ", "");

  }
  
}
