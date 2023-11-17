package com.vulnerabilidade.DTOS.response;

import com.vulnerabilidade.classes.Funcionario;
import com.vulnerabilidade.enumeration.Role;

public record FuncionarioResponseDTO( Long funcionario_id,
                                      String funcionario_usuario,
                                      String funcionario_senha,
                                      String funcionario_departamento,
                                      String funcionario_funcao,
                                      Float funcionario_salario,
                                      Role funcionario_role){

  public FuncionarioResponseDTO(Funcionario funcionario){

    this( funcionario.getFuncionario_id(), 
          funcionario.getFuncionario_usuario(),
          funcionario.getFuncionario_senha(),
          funcionario.getFuncionario_departamento(),
          funcionario.getFuncionario_funcao(),
          funcionario.getFuncionario_salario(),
          funcionario.getFuncionario_role());

  }
  
}
