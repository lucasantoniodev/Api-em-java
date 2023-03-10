package com.algaworks.algalogapi.domain.repository;

import com.algaworks.algalogapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Definindo que é um componente spring do tipo Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNome(String nome);

    List<Cliente> findByNomeContaining(String nome);

    Optional<Cliente> findByEmail(String email);
}
