package com.algaworks.algalogapi.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Implementando Equals e Hashcode com critério do ID
@Getter // Gerando métodos getter e setter para todas as propriedades
@Setter
@Entity // Declarando que é uma entidade para o banco de dados
@Table(name = "cliente") // Nomeando a tabela da entidade
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia para gerar o ID
    @EqualsAndHashCode.Include // Expecificando qual a propriedade irá receber o critério para Equals e o Hashcode
    private Long id;

    @Column(name = "name")
    private String nome;
    @Column(name = "mail")
    private String email;
    @Column(name = "fone")
    private String telefone;


    @Override
    public String toString() {
        return "Cliente: {\n" +
                "       id: " + id + "," + "\n" +
                "       nome: " + nome + "," + "\n" +
                "       email: '" + email + '\'' + "," + "\n" +
                "       telefone: '" + telefone + '\'' + "," + "\n" +
                "}";
    }
}
