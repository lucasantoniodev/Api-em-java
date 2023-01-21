package com.algaworks.algalogapi.api.controller;

import com.algaworks.algalogapi.domain.model.Cliente;
import com.algaworks.algalogapi.domain.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/*
 * Content negotiation é a capacidade do cliente negociar o tipo de retorno do conteúdo.
 * Example: Resposta como um .xml ou .json
 * Biblioteca para suporte a ambos: com.fasterxml.jackson.dataformat
 * */
@AllArgsConstructor // Gera construtor para todas as propriedades
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarDados(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);

        final Cliente clienteUpdated = clienteRepository.save(cliente);

        return ResponseEntity.ok(clienteUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarClientePorID(@PathVariable long id) {
        return clienteRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
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