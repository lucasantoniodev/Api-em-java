package com.algaworks.algalogapi.api.controller;

import com.algaworks.algalogapi.domain.model.Cliente;
import com.algaworks.algalogapi.domain.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/*
 * Content negotiation é a capacidade do cliente negociar o tipo de retorno do conteúdo.
 * Example: Resposta como um .xml ou .json
 * Biblioteca para suporte a ambos: com.fasterxml.jackson.dataformat
 * */
@RestController
@AllArgsConstructor // Gera construtor para todas as propriedades
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente")
    public Cliente listarCliente() {
        return clienteRepository.findByNome("teco");
    }

    @GetMapping("/clientesaleatorios")
    public List<Cliente> listarClientesAleatorios() {
        return clienteRepository.findByNomeContaining("o");
    }
}


/*
 *  @RestController
public class ClienteController {

    @PersistenceContext // Injeta um entityManeger na variável/propriedade "manager"
    private EntityManager manager; // Usa para refletir as operações no banco de dados

    // Define que queremos injentar uma instância que está sendo gerenciada pelo spring

      // Definindo a rota e o método
    @GetMapping("/clientes") // Método get Idempotente é quando requisições feitas seguidamente não geram efeitos colaterais (Não tem alteração no status)

    public List<Cliente> listar() {
        return manager.createQuery("from Cliente", Cliente.class).getResultList(); // JPQL - Linguagem de consulta do jakater persistence
    }
}
 */