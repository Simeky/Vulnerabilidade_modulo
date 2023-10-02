package com.vulnerabilidade.controllers;

import com.vulnerabilidade.DTOS.request.FuncionarioRequestDTO;
import com.vulnerabilidade.DTOS.response.FuncionarioResponseDTO;
import com.vulnerabilidade.classes.Funcionario;
import com.vulnerabilidade.repositorios.FuncionarioRepositorio;
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
@RequestMapping("funcionario")
public class FuncionarioController {

  @Autowired
  private FuncionarioRepositorio repositorio;

  //Create
  @PostMapping
  public void cadastro_funcionario(@RequestBody FuncionarioRequestDTO data){

    Funcionario funcionario_dados = new Funcionario(data);
    repositorio.save(funcionario_dados);
    return;

  }

  //Read
  @GetMapping
  public List<FuncionarioResponseDTO> getAll(){

    List<FuncionarioResponseDTO> funcionario_list = repositorio.findAll().stream().map(FuncionarioResponseDTO::new).toList();
    return funcionario_list;
    
  }

  //Update
  @PutMapping("/{funcionario_id}")
  public ResponseEntity<FuncionarioResponseDTO> update_funcionario(@PathVariable Long funcionario_id, @RequestBody FuncionarioRequestDTO data) {

    Optional<Funcionario> funcionario_optional = repositorio.findById(funcionario_id);
    if (funcionario_optional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Funcionario funcionario = funcionario_optional.get();
    funcionario.setFuncionario_nome(data.funcionario_nome());
    funcionario.setFuncionario_email(data.funcionario_email());
    funcionario.setFuncionario_cpf(data.funcionario_cpf());
    funcionario.setFuncionario_contato(data.funcionario_contato());
    funcionario.setFuncionario_funcao(data.funcionario_funcao());
    funcionario.setFuncionario_senha(data.funcionario_senha());
    FuncionarioResponseDTO responseDTO = new FuncionarioResponseDTO(funcionario);
    return ResponseEntity.ok(responseDTO);
  }

  //Delete
  @DeleteMapping("/{funcionario_id}")
  public ResponseEntity<Void> delete_funcionario(@PathVariable Long funcionario_id) {

  Optional<Funcionario> funcionario_optional = repositorio.findById(funcionario_id);
  if (funcionario_optional.isEmpty()) {
    return ResponseEntity.notFound().build();
  }
  
  repositorio.deleteById(funcionario_id);
  return ResponseEntity.noContent().build();
}

}
