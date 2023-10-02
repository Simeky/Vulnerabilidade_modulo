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

@Table(name = "apoio")
@Entity(name = "apoio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "apoio_id")

public class Apoio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apoio_id;

    private String apoio_nome;
    private String apoio_instituicao;
    private String apoio_descricao;

    @ManyToOne
    @JoinColumn(name = "apoio_familia_id", referencedColumnName = "familia_id", nullable = false)
    private Familia apoio_familia_id;

    private Date apoio_data_inicio;
    private Date apoio_data_termino;

}
