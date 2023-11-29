package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.vulnerabilidade.classes.Users;

public interface UsersRepositorio extends JpaRepository<Users, Long>{

  UserDetails findByLogin(String login);
  
}
