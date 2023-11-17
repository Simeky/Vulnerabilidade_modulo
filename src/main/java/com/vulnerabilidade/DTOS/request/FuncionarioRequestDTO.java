package com.vulnerabilidade.DTOS.request;

import com.vulnerabilidade.enumeration.Role;

public record FuncionarioRequestDTO(Long funcionario_id,
                                    String funcionario_usuario,
                                    String funcionario_senha,
                                    String funcionario_departamento,
                                    String funcionario_funcao,
                                    Float funcionario_salario,
                                    Role funcionario_role){}
