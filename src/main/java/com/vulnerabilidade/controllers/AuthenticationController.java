package com.vulnerabilidade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vulnerabilidade.DTOS.request.AuthenticationRequestDTO;
import com.vulnerabilidade.DTOS.response.LoginResponseDTO;
import com.vulnerabilidade.DTOS.response.UsersResponseDTO;
import com.vulnerabilidade.classes.Users;
import com.vulnerabilidade.infra.security.TokenService;
import com.vulnerabilidade.repositorios.UsersRepositorio;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authentication_manager;

  @Autowired
  TokenService tokenService;

  @Autowired
  private UsersRepositorio repositorio;

  // login
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping("login")
  public ResponseEntity login(@RequestBody @Validated AuthenticationRequestDTO data) {

    var senha = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
    var auth = this.authentication_manager.authenticate(senha);

    var token = tokenService.generate_token((Users) auth.getPrincipal());

    return ResponseEntity.ok(new LoginResponseDTO(token));

  }

  // Cadastro funcionario/usuário
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping("Add_user")
  public ResponseEntity cadastro(@RequestBody @Validated UsersResponseDTO user) {


    if (this.repositorio.findByLogin(user.login()) != null)
      return ResponseEntity.badRequest().build();

    String senha_encripitada = new BCryptPasswordEncoder().encode(user.senha());
    Users novo_usuario = new Users(user.login(), senha_encripitada,
        user.role());

    this.repositorio.save(novo_usuario);

    return ResponseEntity.ok().build();

  }

}
