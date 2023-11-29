package com.vulnerabilidade.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.vulnerabilidade.repositorios.UsersRepositorio;

@Service
public class AuthorizationService implements UserDetailsService{

  @Autowired
  UsersRepositorio repositorio;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repositorio.findByLogin(username);
  }
  
}
