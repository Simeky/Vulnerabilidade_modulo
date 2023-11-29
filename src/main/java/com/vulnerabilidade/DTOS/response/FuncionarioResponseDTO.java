package com.vulnerabilidade.DTOS.response;

import com.vulnerabilidade.classes.Funcionario;

public record FuncionarioResponseDTO( Long funcionario_id,
                                      String funcionario_departamento,
                                      String funcionario_funcao,
                                      Float funcionario_salario){

  public FuncionarioResponseDTO(Funcionario funcionario){

    this( funcionario.getFuncionario_id(), 
          funcionario.getFuncionario_departamento(),
          funcionario.getFuncionario_funcao(),
          funcionario.getFuncionario_salario());

  }
  
}
