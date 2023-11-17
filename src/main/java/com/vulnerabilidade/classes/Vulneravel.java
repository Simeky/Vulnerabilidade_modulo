package com.vulnerabilidade.classes;

import com.vulnerabilidade.DTOS.response.VulneravelResponseDTO;
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

@Table(name = "vulneravel")
@Entity(name = "vulneravel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "vulneravel_id")
public class Vulneravel{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long vulneravel_id;

  @OneToOne
  @MapsId
  private Pessoa vulneravel;

  private Boolean vulneravel_esta_trabalhando;
  private String vulneravel_trabalho;
  private Float vulneravel_salario;
  private Long vulneravel_familia_id;

  public Vulneravel(VulneravelResponseDTO data) {

        vulneravel_esta_trabalhando  = data.vulneravel_esta_trabalhando();
        vulneravel_trabalho          = data.vulneravel_trabalho();
        vulneravel_salario           = data.vulneravel_salario();
        vulneravel_familia_id        = data.vulneravel_familia_id();

    }

}
