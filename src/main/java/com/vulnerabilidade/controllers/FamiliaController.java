/*
 * Esta classe representa o controlador (controller) responsável por gerenciar as operações relacionadas à entidade Familia.
 * Os métodos CRUD (Create, Read, Update, Delete) são mapeados para as operações HTTP (POST, GET, PUT, DELETE) e definem
 * como a aplicação responde às requisições relacionadas às famílias em vulnerabilidade.
 */

package com.vulnerabilidade.controllers;

import com.vulnerabilidade.repositorios.FamiliaRepositorio;
import jakarta.transaction.Transactional;
import com.vulnerabilidade.DTOS.request.FamiliaRequestDTO;
import com.vulnerabilidade.DTOS.response.FamiliaResponseDTO;
import com.vulnerabilidade.classes.Familia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("familia")
@CrossOrigin(originPatterns = {"http://127.0.0.1:5500", "http://localhost:8080"}, allowedHeaders = "*")
public class FamiliaController {

  @Autowired
  private FamiliaRepositorio repositorio;

  // Create
  @PostMapping("Add_familia")
  @Transactional
  public Familia cadastro_familia(@RequestBody FamiliaRequestDTO data) {

    // Método para cadastrar uma nova família com base nos dados recebidos no formato de DTO.
    Familia familia_dados = new Familia(data);
    return repositorio.save(familia_dados);
  }

  // Read

  @GetMapping("familias")
  public List<FamiliaResponseDTO> getAll() {

    // Método para recuperar todas as famílias cadastradas e mapear para um DTO de resposta.
    List<FamiliaResponseDTO> familia_list = repositorio.findAll().stream().map(FamiliaResponseDTO::new).toList();
    return familia_list;
  }

@GetMapping("/get_{familia_id}")
public ResponseEntity<FamiliaResponseDTO> getOne(@PathVariable Long familia_id) {
    // Método para recuperar uma família específica com base no ID e mapear para um DTO de resposta.
    Optional<Familia> familiaOptional = repositorio.findById(familia_id);
    
    if (familiaOptional.isPresent()) {
        Familia familia = familiaOptional.get();
        FamiliaResponseDTO responseDTO = new FamiliaResponseDTO(familia);
        return ResponseEntity.ok(responseDTO);
    } else {
        // Se a família não for encontrada, retornar uma resposta 404 Not Found.
        return ResponseEntity.notFound().build();
    }
}

  // Update
  @PutMapping("/update_{familia_id}")
  @Transactional
  public ResponseEntity<FamiliaResponseDTO> update_familia(@PathVariable Long familia_id, @RequestBody FamiliaRequestDTO data) {

    // Método para atualizar os dados de uma família existente com base no ID e nos dados recebidos no formato de DTO.
    Optional<Familia> familia_optional = repositorio.findById(familia_id);
    if (familia_optional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Familia familia = familia_optional.get();
    familia.setFamilia_nome_responsavel1(data.familia_nome_responsavel1());
    familia.setFamilia_nome_responsavel2(data.familia_nome_responsavel2());
    familia.setFamilia_cpf_responsavel1(data.familia_cpf_responsavel1());
    familia.setFamilia_cpf_responsavel2(data.familia_cpf_responsavel2());
    familia.setFamilia_qtd_membros(data.familia_qtd_membros());
    familia.setFamilia_qtd_filhos(data.familia_qtd_filhos());
    familia.setFamilia_contato(data.familia_contato());
    familia.setFamilia_renda(data.familia_renda());
    familia.setFamilia_necessidades(data.familia_necessidades());
    familia.setFamilia_nivel_vulnerabilidade(data.familia_nivel_vulnerabilidade());
    familia.setFamilia_membros_deficiencia(data.familia_membros_deficiencia());
    familia.setFamilia_data_visita(data.familia_data_visita());
  
    familia = repositorio.save(familia);
    FamiliaResponseDTO responseDTO = new FamiliaResponseDTO(familia);
    return ResponseEntity.ok(responseDTO);
  }

  // Delete
  @DeleteMapping("/delete_{familia_id}")
  @Transactional
  public ResponseEntity<Void> delete_familia(@PathVariable Long familia_id) {

    // Método para deletar uma família existente com base no ID.
    Optional<Familia> familia_optional = repositorio.findById(familia_id);
    if (familia_optional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    repositorio.deleteById(familia_id);
    return ResponseEntity.noContent().build();
  }
}
