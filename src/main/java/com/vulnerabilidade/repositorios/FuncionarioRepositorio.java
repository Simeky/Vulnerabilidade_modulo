package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.vulnerabilidade.classes.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

  UserDetails findByFuncionario_usuario(String funcionario_usuario);
  
}
