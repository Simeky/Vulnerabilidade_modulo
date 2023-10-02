package com.vulnerabilidade.DTOS.request;

public record FamiliaRequestDTO(Long familia_id,
                                String familia_nome_responsavel1,
                                String familia_nome_responsavel2,    
                                String familia_cpf_responsavel1,
                                String familia_cpf_responsavel2,
                                Integer familia_qtd_filhos,
                                String familia_contato){

}
