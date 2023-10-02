package com.vulnerabilidade.classes;

import java.sql.Date;
import com.vulnerabilidade.DTOS.request.RelatorioRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "relatorio")
@Entity(name = "relatorio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "relatorio_id")

public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relatorio_id;

    private String relatorio_necessidades;
    private Float relatorio_renda;
    private Integer relatorio_nivel_vulnerabilidade;
    private Date relatorio_data;

    @OneToOne
    @JoinColumn(name = "relatorio_familia_id", referencedColumnName = "familia_id", nullable = false)
    private Familia relatorio_familia_id;

    private Date relatorio_data_visita;

    public Relatorio(RelatorioRequestDTO data) {

        relatorio_necessidades = data.relatorio_necessidades();
        relatorio_renda = data.relatorio_renda();
        relatorio_nivel_vulnerabilidade = data.relatorio_nivel_vulnerabilidade();
        relatorio_data = data.relatorio_data();
        relatorio_familia_id = data.relatorio_familia_id();
        relatorio_data_visita = data.relatorio_data_visita();

    }

}
