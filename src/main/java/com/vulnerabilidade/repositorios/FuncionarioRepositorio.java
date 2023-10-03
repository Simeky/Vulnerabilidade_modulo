package com.vulnerabilidade.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vulnerabilidade.classes.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

  Optional<Funcionario> findByFuncionario_email(String funcionario_email);
  
}
