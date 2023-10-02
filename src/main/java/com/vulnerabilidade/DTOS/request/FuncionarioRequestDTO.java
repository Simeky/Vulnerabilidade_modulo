package com.vulnerabilidade.DTOS.request;

public record FuncionarioRequestDTO(Long funcionario_id,
                                    String funcionario_nome,
                                    String funcionario_email,
                                    String funcionario_cpf,
                                    String funcionario_contato,
                                    String funcionario_funcao,
                                    String funcionario_senha){}
