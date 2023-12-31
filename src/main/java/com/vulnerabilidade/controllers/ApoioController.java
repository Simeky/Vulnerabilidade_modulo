package com.vulnerabilidade.controllers;

import com.vulnerabilidade.DTOS.response.ApoioResponseDTO;
import com.vulnerabilidade.repositorios.ApoioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apoio")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApoioController {

  @Autowired
  private ApoioRepositorio repositorio;

  //Read
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public List<ApoioResponseDTO> getAll() {

    List<ApoioResponseDTO> apoio_list = repositorio.findAll().stream().map(ApoioResponseDTO::new).toList();
    return apoio_list;

  }

}
