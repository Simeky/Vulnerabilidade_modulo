package com.vulnerabilidade.DTOS.request;

import java.sql.Date;

public record FamiliaRequestDTO(Long familia_id,
                                String familia_nome_responsavel1,
                                String familia_nome_responsavel2,    
                                String familia_cpf_responsavel1,
                                String familia_cpf_responsavel2,
                                Integer familia_qtd_filhos,
                                String familia_contato,
                                Float familia_renda,
                                String familia_necessidades,
                                Integer familia_nivel_vulnerabilidade,
                                Date familia_data_visita){

}
