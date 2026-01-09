package com.bezkoder.spring.data.jpa.pagingsorting.repository;

import com.bezkoder.spring.data.jpa.pagingsorting.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    Optional<Entrega> findByNombreIgnoreCase(String nombre);
}
