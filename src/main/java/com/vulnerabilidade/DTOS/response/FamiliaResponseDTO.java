package com.vulnerabilidade.DTOS.response;

import java.sql.Date;

import com.vulnerabilidade.classes.Familia;

public record FamiliaResponseDTO(Long familia_id,            
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

  public FamiliaResponseDTO(Familia familia){    
    this(familia.getFamilia_id(),
         familia.getFamilia_nome_responsavel1(),
         familia.getFamilia_nome_responsavel2(),
         familia.getFamilia_cpf_responsavel1(),
         familia.getFamilia_cpf_responsavel2(), 
         familia.getFamilia_qtd_filhos(), 
         familia.getFamilia_contato(),
         familia.getFamilia_renda(),
         familia.getFamilia_necessidades(),
         familia.getFamilia_nivel_vulnerabilidade(),
         familia.getFamilia_data_visita());
  }

}
