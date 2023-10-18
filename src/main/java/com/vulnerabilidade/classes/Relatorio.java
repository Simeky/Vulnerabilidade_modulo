package com.vulnerabilidade.classes;

import java.sql.Date;
import com.vulnerabilidade.DTOS.request.RelatorioRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "relatorio")
@Entity(name = "relatorio")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "relatorio_id")

public class Relatorio {

    @Id
    @Column(name = "relatorio_id")
    private Long relatorio_id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Familia familia;

    private String relatorio_necessidades;
    private Float relatorio_renda;
    private Integer relatorio_nivel_vulnerabilidade;
    private Date relatorio_data;


    private Date relatorio_data_visita;

    public Relatorio(RelatorioRequestDTO data) {

        relatorio_necessidades = data.relatorio_necessidades();
        familia = data.familia();
        relatorio_renda = data.relatorio_renda();
        relatorio_nivel_vulnerabilidade = data.relatorio_nivel_vulnerabilidade();
        relatorio_data = data.relatorio_data();
        relatorio_data_visita = data.relatorio_data_visita();

    }

}
