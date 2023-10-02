package com.vulnerabilidade.DTOS.response;

import com.vulnerabilidade.classes.Funcionario;

public record FuncionarioResponseDTO(Long funcionario_id,
                                    String funcionario_nome,
                                    String funcionario_email,
                                    String funcionario_cpf,
                                    String funcionario_contato,
                                    String funcionario_funcao,
                                    String funcionario_senha){

  public FuncionarioResponseDTO(Funcionario funcionario){

    this( funcionario.getFuncionario_id(), 
          funcionario.getFuncionario_nome(), 
          funcionario.getFuncionario_email(), 
          funcionario.getFuncionario_cpf(), 
          funcionario.getFuncionario_contato(), 
          funcionario.getFuncionario_funcao(), 
          funcionario.getFuncionario_senha());

  }
  
}
