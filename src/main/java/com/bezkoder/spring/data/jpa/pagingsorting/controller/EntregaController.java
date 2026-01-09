package com.bezkoder.spring.data.jpa.pagingsorting.controller;

import com.bezkoder.spring.data.jpa.pagingsorting.model.Entrega;
import com.bezkoder.spring.data.jpa.pagingsorting.repository.EntregaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    private final EntregaRepository entregaRepository;

    public EntregaController(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @GetMapping
    public List<Entrega> getAll() {
        return entregaRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Entrega> getById(@PathVariable Long id) {
        return entregaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
