package com.vulnerabilidade.DTOS.request;

import java.sql.Date;
import com.vulnerabilidade.classes.Familia;

public record RelatorioRequestDTO(Long relatorio_id,
                                  Familia familia,
                                  String relatorio_necessidades,
                                  Float relatorio_renda,
                                  Integer relatorio_nivel_vulnerabilidade,
                                  Date relatorio_data,                                  
                                  Date relatorio_data_visita){}