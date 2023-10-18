package com.vulnerabilidade.controllers;

import com.vulnerabilidade.DTOS.response.PessoaResponseDTO;
import com.vulnerabilidade.repositorios.PessoaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

  @Autowired
  private PessoaRepositorio repositorio;

  @GetMapping
  public List<PessoaResponseDTO> getAll(){

    List<PessoaResponseDTO> pessoa_list = repositorio.findAll().stream().map(PessoaResponseDTO::new).toList();
    return pessoa_list;
    
  }

}
