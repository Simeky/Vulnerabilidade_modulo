package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vulnerabilidade.classes.Familia;

public interface FamiliaRepositorio extends JpaRepository<Familia, Long>{
    
}