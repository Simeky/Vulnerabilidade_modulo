/*
 * Esta classe representa a entidade "Familia" no sistema, que é mapeada para a tabela "familia" no banco de dados.
 * Utiliza a anotação @Entity para indicar que é uma entidade JPA.
 * 
 * Os atributos correspondem aos campos da tabela "familia", e as anotações JPA como @Id e @GeneratedValue são usadas
 * para indicar que "familia_id" é a chave primária gerada automaticamente.
 * 
 * As relações com outras entidades são mapeadas usando anotações como @OneToMany e @ManyToMany.
 * O construtor recebe um objeto FamiliaRequestDTO para facilitar a criação de instâncias da classe.
 * 
 * Utiliza as anotações Lombok como @Getter, @Setter, @AllArgsConstructor, @NoArgsConstructor para gerar automaticamente
 * métodos getter, setter, construtores com e sem argumentos, e equals/hashCode.
 */

package com.vulnerabilidade.classes;

import java.sql.Date;
import java.util.Set;
import com.vulnerabilidade.DTOS.request.FamiliaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private Integer familia_qtd_membros;
    private Integer familia_qtd_filhos;
    private String familia_contato;
    private Float familia_renda;
    private String familia_necessidades;
    private Integer familia_nivel_vulnerabilidade;
    private Boolean familia_membros_deficiencia;
    private Date familia_data_visita;

    @ManyToMany(mappedBy = "apoio_familias_id")
    private Set<Apoio> apoios;

    /*
     * Construtor que recebe um objeto FamiliaRequestDTO e inicializa os atributos da classe.
     * Facilita a criação de instâncias de Familia a partir de dados fornecidos via requisição.
     */
    public Familia(FamiliaRequestDTO data) {
        familia_nome_responsavel1       = data.familia_nome_responsavel1();
        familia_nome_responsavel2       = data.familia_nome_responsavel2();
        familia_cpf_responsavel1        = data.familia_cpf_responsavel1();
        familia_cpf_responsavel2        = data.familia_cpf_responsavel2();
        familia_qtd_membros             = data.familia_qtd_membros();
        familia_qtd_filhos              = data.familia_qtd_filhos();
        familia_contato                 = data.familia_contato();
        familia_renda                   = data.familia_renda();
        familia_necessidades            = data.familia_necessidades();
        familia_nivel_vulnerabilidade   = data.familia_nivel_vulnerabilidade();
        familia_membros_deficiencia     = data.familia_membros_deficiencia();
        familia_data_visita             = data.familia_data_visita();
    }
}
