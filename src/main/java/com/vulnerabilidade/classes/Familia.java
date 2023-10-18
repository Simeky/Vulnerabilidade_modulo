package com.vulnerabilidade.classes;

import java.util.List;
import com.vulnerabilidade.DTOS.request.FamiliaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "familia")
@Entity(name = "familia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "familia_id")

public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long familia_id;

    private String familia_nome_responsavel1;
    private String familia_nome_responsavel2;
    private String familia_cpf_responsavel1;
    private String familia_cpf_responsavel2;
    private Integer familia_qtd_filhos;
    private String familia_contato;

    @OneToMany(mappedBy = "pessoa_familia_id")
    private List<Pessoa> pessoas;


    @OneToMany(mappedBy = "apoio_familia_id")
    private List<Apoio> apoios;

    public Familia(FamiliaRequestDTO data) {

        familia_nome_responsavel1 = data.familia_nome_responsavel1();
        familia_nome_responsavel2 = data.familia_nome_responsavel2();
        familia_cpf_responsavel1 = data.familia_cpf_responsavel1();
        familia_cpf_responsavel2 = data.familia_cpf_responsavel2();
        familia_qtd_filhos = data.familia_qtd_filhos();
        familia_contato = data.familia_contato();

    }
}
