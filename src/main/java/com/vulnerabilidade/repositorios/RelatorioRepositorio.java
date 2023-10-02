package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vulnerabilidade.classes.Relatorio;

public interface RelatorioRepositorio extends JpaRepository<Relatorio, Long>{
    
}
