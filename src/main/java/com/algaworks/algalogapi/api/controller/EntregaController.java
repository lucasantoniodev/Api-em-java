package com.algaworks.algalogapi.api.controller;

import com.algaworks.algalogapi.domain.model.Entrega;
import com.algaworks.algalogapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor // Gera construtor para todas as propriedades
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitarEntregaHandler(@RequestBody Entrega entrega) {
        return solicitacaoEntregaService.solicitar(entrega);
    }
}
