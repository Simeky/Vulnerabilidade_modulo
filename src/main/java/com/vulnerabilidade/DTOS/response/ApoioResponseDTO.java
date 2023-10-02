package com.vulnerabilidade.DTOS.response;

import java.sql.Date;
import com.vulnerabilidade.classes.Apoio;
import com.vulnerabilidade.classes.Familia;

public record ApoioResponseDTO(  Long apoio_id,
                                String apoio_nome,
                                String apoio_instituicao,
                                String apoio_descricao,
                                Familia apoio_familia_id,
                                Date apoio_data_inicio,
                                Date apoio_data_termino ){

  public ApoioResponseDTO(Apoio apoio){

    this( apoio.getApoio_id(), 
          apoio.getApoio_nome(), 
          apoio.getApoio_instituicao(), 
          apoio.getApoio_descricao(), 
          apoio.getApoio_familia_id(), 
          apoio.getApoio_data_inicio(), 
          apoio.getApoio_data_termino());

  }

}