/*
 * Esta classe representa o DTO (Data Transfer Object) usado para receber dados do cliente
 * ao criar ou atualizar informações sobre uma Família. Utiliza a palavra-chave "record" do Java,
 * introduzida no Java 14, para criar automaticamente um registro imutável com métodos equals, hashCode e toString.
 * 
 * O DTO contém os mesmos atributos da entidade Familia, permitindo a transferência de dados entre a camada de
 * apresentação (front-end) e o backend. O uso de records simplifica a criação de objetos imutáveis.
 */

package com.vulnerabilidade.DTOS.request;

import java.sql.Date;

public record FamiliaRequestDTO(
    Long familia_id,
    String familia_nome_responsavel1,
    String familia_nome_responsavel2,    
    String familia_cpf_responsavel1,
    String familia_cpf_responsavel2,
    Integer familia_qtd_membros,
    Integer familia_qtd_filhos,
    String familia_contato,
    Float familia_renda,
    String familia_necessidades,
    Integer familia_nivel_vulnerabilidade,
    Boolean familia_membros_deficiencia,
    Date familia_data_visita
) {
    
}
