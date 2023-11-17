package com.vulnerabilidade.DTOS.request;

import com.vulnerabilidade.classes.Vulneravel;
import java.sql.Date;
import com.vulnerabilidade.classes.Pessoa;
import com.vulnerabilidade.enumeration.Genero;
import com.vulnerabilidade.enumeration.Deficiencia_tipo;

public record Pessoa_vulneravelRequestDTO( Long vulneravel_id,                    String pessoa_cpf, 
                                            String pessoa_nome,                   String pessoa_contato,
                                            String pessoa_email,                  Genero pessoa_genero,
                                            Date pessoa_nascimento,               String pessoa_cep,
                                            String pessoa_rua,                    String pessoa_bairro,
                                            String pessoa_cidade,                 String pessoa_estado,
                                            String pessoa_nr_residencia,                            
                                            Deficiencia_tipo pessoa_deficiencia_tipo,
                                            String pessoa_deficiencia,
                                            Boolean vulneravel_esta_trabalhando,  String vulneravel_trabalho,
                                            Float vulneravel_salario,
                                            Long vulneravel_familia_id){

  public Pessoa_vulneravelRequestDTO(Vulneravel vulneravel, Pessoa pessoa){

    this( vulneravel.getVulneravel_id(),
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
          pessoa.getPessoa_deficiencia_tipo(),
          pessoa.getPessoa_deficiencia() ,
          vulneravel.getVulneravel_esta_trabalhando(),
          vulneravel.getVulneravel_trabalho(),
          vulneravel.getVulneravel_salario(),
          vulneravel.getVulneravel_familia_id());

  }
}