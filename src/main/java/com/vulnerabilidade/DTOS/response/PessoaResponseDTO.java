package com.vulnerabilidade.DTOS.response;

import java.sql.Date;

import com.vulnerabilidade.classes.Familia;
import com.vulnerabilidade.classes.Pessoa;

public record PessoaResponseDTO(Long pessoa_id,                String pessoa_cpf, 
                               String pessoa_nome,             String pessoa_contato,
                               String pessoa_email,            String pessoa_genero,
                               Date pessoa_nascimento,         String pessoa_cep,
                               String pessoa_rua,              String pessoa_bairro,
                               String pessoa_cidade,           String pessoa_estado,
                               String pessoa_nr_residencia,   String pessoa_usuario,
                               String pessoa_senha,            Familia pessoa_familia_id) {
    
  public PessoaResponseDTO(Pessoa pessoa){

    this( pessoa.getPessoa_id(), 
          pessoa.getPessoa_cpf(), 
          pessoa.getPessoa_nome(), 
          pessoa.getPessoa_contato(), 
          pessoa.getPessoa_email(), 
          pessoa.getPessoa_genero(), 
          pessoa.getPessoa_nascimento(), 
          pessoa.getPessoa_cep(), 
          pessoa.getPessoa_rua(), 
          pessoa.getPessoa_bairro(), 
          pessoa.getPessoa_cidade(), 
          pessoa.getPessoa_estado(), 
          pessoa.getPessoa_nr_residencia(), 
          pessoa.getPessoa_usuario(), 
          pessoa.getPessoa_senha(), 
          pessoa.getPessoa_familia_id());
  }
                                    
}
