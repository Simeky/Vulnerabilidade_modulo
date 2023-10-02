package com.vulnerabilidade.classes;

import com.vulnerabilidade.DTOS.request.FuncionarioRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "funcionario")
@Entity(name = "funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "funcionario_id")

public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long funcionario_id;
  private String funcionario_nome;
  private String funcionario_email;
  private String funcionario_cpf;
  private String funcionario_contato;
  private String funcionario_funcao;
  private String funcionario_senha;

  public Funcionario(FuncionarioRequestDTO data) {
    
    funcionario_nome = data.funcionario_nome();
    funcionario_email = data.funcionario_email();
    funcionario_cpf = data.funcionario_cpf();
    funcionario_contato = data.funcionario_contato();
    funcionario_funcao = data.funcionario_funcao();
    funcionario_senha = data.funcionario_senha();

  }
}
