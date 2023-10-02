package com.vulnerabilidade.DTOS.response;

import java.sql.Date;

import com.vulnerabilidade.classes.Familia;
import com.vulnerabilidade.classes.Relatorio;

public record RelatorioResponseDTO(  Long relatorio_id,
                                    String relatorio_necessidades,
                                    Float relatorio_renda,
                                    Integer relatorio_nivel_vulnerabilidade,
                                    Date relatorio_data,
                                    Familia relatorio_familia_id,
                                    Date relatorio_data_visita

){

  public RelatorioResponseDTO(Relatorio relatorio){

    this( relatorio.getRelatorio_id(), 
          relatorio.getRelatorio_necessidades(), 
          relatorio.getRelatorio_renda(), 
          relatorio.getRelatorio_nivel_vulnerabilidade(), 
          relatorio.getRelatorio_data(), 
          relatorio.getRelatorio_familia_id(), 
          relatorio.getRelatorio_data_visita());

  }

}