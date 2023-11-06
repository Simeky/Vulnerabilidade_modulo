package com.vulnerabilidade.classes;

import java.sql.Date;
import java.util.List;
import com.vulnerabilidade.DTOS.response.ApoioResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "familia_apoio",
	           joinColumns = @JoinColumn(name ="apoio_id"),
	           inverseJoinColumns = @JoinColumn(name ="familia_id"))
    private List<Familia> apoio_familias_id;

    private Date apoio_data_inicio;
    private Date apoio_data_termino;


    public Apoio(ApoioResponseDTO data) {

        apoio_id                = data.apoio_id();
        apoio_nome              = data.apoio_nome();
        apoio_instituicao       = data.apoio_instituicao();
        apoio_descricao         = data.apoio_descricao();
        apoio_familias_id       = data.apoio_familias_id();
        apoio_data_inicio       = data.apoio_data_inicio();
        apoio_data_termino      = data.apoio_data_termino();

    }

}
