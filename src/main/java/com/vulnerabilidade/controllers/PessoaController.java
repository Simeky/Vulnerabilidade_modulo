package com.vulnerabilidade.controllers;

import com.vulnerabilidade.DTOS.request.Pessoa_funcionarioRequestDTO;
import com.vulnerabilidade.DTOS.request.Pessoa_vulneravelRequestDTO;
import com.vulnerabilidade.DTOS.response.PessoaResponseDTO;
import com.vulnerabilidade.classes.Funcionario;
import com.vulnerabilidade.classes.Pessoa;
import com.vulnerabilidade.classes.Vulneravel;
import com.vulnerabilidade.repositorios.FuncionarioRepositorio;
import com.vulnerabilidade.repositorios.PessoaRepositorio;
import com.vulnerabilidade.repositorios.VulneravelRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {

  @Autowired
  private PessoaRepositorio repositorio_pes;

  @Autowired
  private FuncionarioRepositorio repositorio_func;
  
  @Autowired
  private VulneravelRepositorio repositorio_vul;

 
  //Read pessoas
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("pessoas")
  public List<PessoaResponseDTO> getAll(){

    List<PessoaResponseDTO> pessoa_list = repositorio_pes.findAll().stream().map(PessoaResponseDTO::new).toList();
    return pessoa_list;
    
  }

  //Read funcionários
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("funcionarios")
  public List<Pessoa_funcionarioRequestDTO> getAll_func() {
    List<Pessoa_funcionarioRequestDTO> funcionario_lista = new ArrayList<>();

    List<Pessoa> pessoas = repositorio_pes.findAll();
    List<Funcionario> funcionarios = repositorio_func.findAll();

    for (int i = 0; i < funcionarios.size(); i++) {
        Pessoa pessoa = pessoas.get(i);
        Funcionario funcionario = funcionarios.get(i);

        Pessoa_funcionarioRequestDTO dto = new Pessoa_funcionarioRequestDTO(funcionario, pessoa);
        funcionario_lista.add(dto);
    }

    return funcionario_lista;
  }

  //Read vulneráveis
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping("vulneraveis")
  public List<Pessoa_vulneravelRequestDTO> getAll_vul() {
    List<Pessoa_vulneravelRequestDTO> vulneravel_lista = new ArrayList<>();

    List<Pessoa> pessoas = repositorio_pes.findAll();
    List<Vulneravel> vulneraveis = repositorio_vul.findAll();

    for (int i = 0; i < vulneraveis.size(); i++) {
        Pessoa pessoa = pessoas.get(i);
        Vulneravel vulneravel = vulneraveis.get(i);

        Pessoa_vulneravelRequestDTO dto = new Pessoa_vulneravelRequestDTO(vulneravel, pessoa);
        vulneravel_lista.add(dto);
    }

    return vulneravel_lista;
  } 


}
