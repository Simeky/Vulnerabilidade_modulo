package com.vulnerabilidade.DTOS.response;


import com.vulnerabilidade.classes.Users;
import com.vulnerabilidade.enumeration.Role;

public record UsersResponseDTO( String login,
                                String senha,
                                Role role
) {

  public UsersResponseDTO(Users user){

    this( user.getLogin(),
          user.getSenha(),
          user.getRole());


  }
  
}
