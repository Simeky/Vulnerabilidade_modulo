package com.vulnerabilidade.DTOS.response;

import com.vulnerabilidade.classes.Vulneravel;

public record VulneravelResponseDTO(Long vulneravel_id, 
                                    Boolean vulneravel_esta_trabalhando, 
                                    String vulneravel_trabalho,
                                    Float vulneravel_salario,
                                    Long vulneravel_familia_id){

  public VulneravelResponseDTO(Vulneravel vulneravel){

    this( vulneravel.getVulneravel_id(),
          vulneravel.getVulneravel_esta_trabalhando(),
          vulneravel.getVulneravel_trabalho(),
          vulneravel.getVulneravel_salario(),
          vulneravel.getVulneravel_familia_id());

  }
  
}
