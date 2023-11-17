package com.vulnerabilidade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vulnerabilidade.DTOS.request.FuncionarioRequestDTO;
import com.vulnerabilidade.DTOS.response.FuncionarioResponseDTO;
import com.vulnerabilidade.DTOS.response.LoginResponseDTO;
import com.vulnerabilidade.classes.Funcionario;
import com.vulnerabilidade.infra.security.TokenService;
import com.vulnerabilidade.repositorios.FuncionarioRepositorio;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authentication_manager;

  @Autowired
  TokenService tokenService;

  @Autowired
  private FuncionarioRepositorio repositorio;
  
  //login
  @PostMapping("login")
  public ResponseEntity login(@RequestBody @Validated FuncionarioRequestDTO data){

    var usuario_senha = new UsernamePasswordAuthenticationToken(data.funcionario_usuario(), data.funcionario_senha());
    var auth = this.authentication_manager.authenticate(usuario_senha);

    var token = tokenService.generate_token((Funcionario)auth.getPrincipal());

    return ResponseEntity.ok(new LoginResponseDTO(token));

  }

  //Cadastro funcionario/usuário
  @PostMapping("Add_funcionario")
  public ResponseEntity cadastro(@RequestBody @Validated FuncionarioResponseDTO funcionario){

    if(this.repositorio.findByFuncionario_usuario(funcionario.funcionario_usuario()) != null) return ResponseEntity.badRequest().build();

    String senha_encripitada = new BCryptPasswordEncoder().encode(funcionario.funcionario_senha());
    Funcionario novo_usuario = new Funcionario(funcionario.funcionario_usuario(), senha_encripitada, funcionario.funcionario_role());
    Funcionario funcionario_dados = new Funcionario(funcionario);

    this.repositorio.save(funcionario_dados);
    this.repositorio.save(novo_usuario);

    return ResponseEntity.ok().build();

  }

}
