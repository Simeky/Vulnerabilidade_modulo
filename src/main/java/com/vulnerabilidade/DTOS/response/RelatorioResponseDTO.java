package com.vulnerabilidade.DTOS.response;

import java.sql.Date;

import com.vulnerabilidade.classes.Familia;
import com.vulnerabilidade.classes.Relatorio;

public record RelatorioResponseDTO( Long relatorio_id,
                                    Familia familia,
                                    String relatorio_necessidades,
                                    Float relatorio_renda,
                                    Integer relatorio_nivel_vulnerabilidade,
                                    Date relatorio_data,                                  
                                    Date relatorio_data_visita

){

  public RelatorioResponseDTO(Relatorio relatorio){

    this( relatorio.getRelatorio_id(),
          relatorio.getFamilia(), 
          relatorio.getRelatorio_necessidades(), 
          relatorio.getRelatorio_renda(), 
          relatorio.getRelatorio_nivel_vulnerabilidade(), 
          relatorio.getRelatorio_data(),           
          relatorio.getRelatorio_data_visita());

  }

}