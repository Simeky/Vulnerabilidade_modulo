package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vulnerabilidade.classes.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

  
}
