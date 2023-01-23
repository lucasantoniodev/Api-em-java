package com.algaworks.algalogapi.domain.service;

import com.algaworks.algalogapi.domain.exception.NegocioException;
import com.algaworks.algalogapi.domain.model.Cliente;
import com.algaworks.algalogapi.domain.model.Entrega;
import com.algaworks.algalogapi.domain.model.StatusEntrega;
import com.algaworks.algalogapi.domain.repository.ClienteRepository;
import com.algaworks.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service // Delegando que é um componente spring com responsabilidades de service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus((StatusEntrega.PENDENTE));
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
