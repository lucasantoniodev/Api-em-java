package com.algaworks.algalogapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 60)
    private String nome;

    @Column(name = "mail")
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @Column(name = "fone")
    @NotBlank
    @Size(max = 20)
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
