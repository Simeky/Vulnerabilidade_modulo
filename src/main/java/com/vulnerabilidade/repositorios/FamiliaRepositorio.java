/*
 * Esta interface representa um repositório JPA (Java Persistence API) para a entidade Familia.
 * Herda da interface JpaRepository, que fornece métodos padrão para operações de persistência,
 * facilitando a interação com o banco de dados.
 */

package com.vulnerabilidade.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vulnerabilidade.classes.Familia;

public interface FamiliaRepositorio extends JpaRepository<Familia, Long> {
    
}
