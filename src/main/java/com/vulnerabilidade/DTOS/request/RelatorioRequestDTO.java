package com.vulnerabilidade.DTOS.request;

import java.sql.Date;
import com.vulnerabilidade.classes.Familia;

public record RelatorioRequestDTO(Long relatorio_id,
                                  String relatorio_necessidades,
                                  Float relatorio_renda,
                                  Integer relatorio_nivel_vulnerabilidade,
                                  Date relatorio_data,
                                  Familia relatorio_familia_id,
                                  Date relatorio_data_visita){}