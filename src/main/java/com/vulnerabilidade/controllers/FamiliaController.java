package com.vulnerabilidade.controllers;

import com.vulnerabilidade.repositorios.FamiliaRepositorio;

import com.vulnerabilidade.DTOS.request.FamiliaRequestDTO;
import com.vulnerabilidade.DTOS.response.FamiliaResponseDTO;
import com.vulnerabilidade.classes.Familia;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("familia")
public class FamiliaController {

  @Autowired
  private FamiliaRepositorio repositorio;

  //Create
  @PostMapping
  public void cadastro_familia(@RequestBody FamiliaRequestDTO data){

    Familia familia_dados = new Familia(data);
    repositorio.save(familia_dados);
    return;

  }  

  //Read
  @GetMapping
  public List<FamiliaResponseDTO> getAll(){

    List<FamiliaResponseDTO> familia_list = repositorio.findAll().stream().map(FamiliaResponseDTO::new).toList();
    return familia_list;
    
  }
  
  //Update
  @PutMapping("/{familia_id}")
  public ResponseEntity<FamiliaResponseDTO> update_familia(@PathVariable Long familia_id, @RequestBody FamiliaRequestDTO data) {

    Optional<Familia> familia_optional = repositorio.findById(familia_id);
    if (familia_optional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Familia familia = familia_optional.get();
    familia.setFamilia_nome_responsavel1(data.familia_nome_responsavel1());
    familia.setFamilia_nome_responsavel2(data.familia_nome_responsavel2());
    familia.setFamilia_cpf_responsavel1(data.familia_cpf_responsavel1());
    familia.setFamilia_cpf_responsavel2(data.familia_cpf_responsavel2());
    familia.setFamilia_qtd_filhos(data.familia_qtd_filhos());
    familia.setFamilia_contato(data.familia_contato());
    familia = repositorio.save(familia);
    FamiliaResponseDTO responseDTO = new FamiliaResponseDTO(familia);
    return ResponseEntity.ok(responseDTO);
  }

  //Delete
  @DeleteMapping("/{familia_id}")
  public ResponseEntity<Void> delete_familia(@PathVariable Long familia_id) {

  Optional<Familia> familia_optional = repositorio.findById(familia_id);
  if (familia_optional.isEmpty()) {
    return ResponseEntity.notFound().build();
  }

  repositorio.deleteById(familia_id);
  return ResponseEntity.noContent().build();
}

}
