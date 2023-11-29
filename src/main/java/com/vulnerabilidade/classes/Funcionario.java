package com.vulnerabilidade.classes;

import com.vulnerabilidade.DTOS.response.FuncionarioResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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

public class Funcionario{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long funcionario_id;

  @OneToOne
  @MapsId
  private Pessoa funcionario;

  private String funcionario_funcao;
  private String funcionario_departamento;
  private Float funcionario_salario; 
  
  public Funcionario(FuncionarioResponseDTO data) {

    funcionario_id            = data.funcionario_id();
    funcionario_departamento  = data.funcionario_departamento();
    funcionario_funcao        = data.funcionario_funcao();
    funcionario_salario       = data.funcionario_salario();

  }
}
