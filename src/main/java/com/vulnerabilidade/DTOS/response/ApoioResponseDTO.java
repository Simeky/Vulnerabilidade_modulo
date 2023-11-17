package com.vulnerabilidade.DTOS.response;

import java.sql.Date;
import java.util.Set;
import com.vulnerabilidade.classes.Apoio;
import com.vulnerabilidade.classes.Familia;

public record ApoioResponseDTO(  Long apoio_id,
                                String apoio_nome,
                                String apoio_instituicao,
                                String apoio_descricao,
                                Set<Familia> apoio_familias_id,
                                Date apoio_data_inicio,
                                Date apoio_data_termino ){

  public ApoioResponseDTO(Apoio apoio){

    this( apoio.getApoio_id(), 
          apoio.getApoio_nome(), 
          apoio.getApoio_instituicao(), 
          apoio.getApoio_descricao(), 
          apoio.getApoio_familias_id(), 
          apoio.getApoio_data_inicio(), 
          apoio.getApoio_data_termino());

  }

}