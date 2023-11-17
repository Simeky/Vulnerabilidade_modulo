package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vulnerabilidade.classes.Vulneravel;

public interface VulneravelRepositorio extends JpaRepository<Vulneravel, Long>{
  
}
