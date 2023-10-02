package com.vulnerabilidade.classes;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    
    private String pessoa_genero;
    private Date pessoa_nascimento;
    private String pessoa_cep;
    private String pessoa_rua;
    private String pessoa_bairro;
    private String pessoa_cidade;
    private String pessoa_estado;
    private String pessoa_nr_residencia;
    private String pessoa_usuario;
    private String pessoa_senha;

    @ManyToOne
    @JoinColumn(name = "pessoa_familia_id", referencedColumnName = "familia_id", nullable = false)
    private Familia pessoa_familia_id;
}