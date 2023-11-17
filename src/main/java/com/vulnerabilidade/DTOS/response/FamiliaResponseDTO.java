/*
 * Esta classe representa a resposta (DTO) que será enviada para o cliente quando informações de uma Família
 * forem solicitadas. Utiliza a palavra-chave "record" do Java, introduzida no Java 14, para criar automaticamente
 * um registro imutável com métodos equals, hashCode e toString.
 * 
 * A resposta contém os mesmos atributos da entidade Familia, mas de forma imutável, garantindo que os dados não 
 * serão modificados após a criação do objeto. Um construtor adicional é fornecido para criar um objeto 
 * FamiliaResponseDTO a partir de uma instância de Familia.
 */

package com.vulnerabilidade.DTOS.response;

import java.sql.Date;
import com.vulnerabilidade.classes.Familia;

public record FamiliaResponseDTO(
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
    
    /*
     * Construtor adicional que cria um objeto FamiliaResponseDTO a partir de uma instância de Familia.
     * Facilita a conversão de dados da entidade para o formato de resposta DTO.
     */
    public FamiliaResponseDTO(Familia familia) {    
        this(
            familia.getFamilia_id(),
            familia.getFamilia_nome_responsavel1(),
            familia.getFamilia_nome_responsavel2(),
            familia.getFamilia_cpf_responsavel1(),
            familia.getFamilia_cpf_responsavel2(),
            familia.getFamilia_qtd_membros(),
            familia.getFamilia_qtd_filhos(), 
            familia.getFamilia_contato(),
            familia.getFamilia_renda(),
            familia.getFamilia_necessidades(),
            familia.getFamilia_nivel_vulnerabilidade(),
            familia.getFamilia_membros_deficiencia(),
            familia.getFamilia_data_visita());
    }
}
