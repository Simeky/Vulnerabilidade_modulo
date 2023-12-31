package com.vulnerabilidade.classes;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.vulnerabilidade.DTOS.response.PessoaResponseDTO;
import com.vulnerabilidade.enumeration.Deficiencia_tipo;
import com.vulnerabilidade.enumeration.Genero;

@Table(name = "pessoa")
@Entity(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "pessoa_id")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoa_id;

    private String pessoa_nome;         
    private String pessoa_cpf;
    private String pessoa_email;        
    private String pessoa_contato;

    @Enumerated(EnumType.STRING)
    private Genero pessoa_genero;
    
    private Date pessoa_nascimento;
    private String pessoa_cep;          
    private String pessoa_rua;
    private String pessoa_bairro;       
    private String pessoa_cidade;
    private String pessoa_estado;       
    private String pessoa_nr_residencia;

    @Enumerated(EnumType.STRING)
    private Deficiencia_tipo pessoa_deficiencia_tipo;

    private String pessoa_deficiencia;
    
    public Pessoa(PessoaResponseDTO data) {

        pessoa_id                       = data.pessoa_id();
        pessoa_cpf                      = data.pessoa_cpf();
        pessoa_nome                     = data.pessoa_nome();
        pessoa_contato                  = data.pessoa_contato();
        pessoa_email                    = data.pessoa_email();
        pessoa_genero                   = data.pessoa_genero();
        pessoa_nascimento               = data.pessoa_nascimento();
        pessoa_cep                      = data.pessoa_cep();
        pessoa_rua                      = data.pessoa_rua();
        pessoa_bairro                   = data.pessoa_bairro();
        pessoa_cidade                   = data.pessoa_cidade();
        pessoa_estado                   = data.pessoa_estado();
        pessoa_nr_residencia            = data.pessoa_nr_residencia();
        pessoa_deficiencia_tipo         = data.pessoa_deficiencia_tipo();
        pessoa_deficiencia              = data.pessoa_deficiencia();     

    }
}