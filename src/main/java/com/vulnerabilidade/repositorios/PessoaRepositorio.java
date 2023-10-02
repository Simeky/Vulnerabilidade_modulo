package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vulnerabilidade.classes.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
    
}
