package com.bezkoder.spring.data.jpa.pagingsorting.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bezkoder.spring.data.jpa.pagingsorting.model.Infraccione;



public interface InfracionesRepository extends JpaRepository<Infraccione,Long> {
	Page<Infraccione> findByNombreContaining(String nombre, Pageable pageable);
	Page<Infraccione> findByDniContaining(String dni, Pageable pageable);
	Page<Infraccione> findByActaContaining(String acta, Pageable pageable);
	Page<Infraccione> findByDominioContaining(String dominio, Pageable pageable);
	Page<Infraccione> findByCausaContaining(String causa, Pageable pageable);
	List<Infraccione> findByNombreContaining(String nombre, Sort sort);
	List<Infraccione> findByDniContaining(String dni, Sort sort);
	List<Infraccione> findByActaContaining(String acta, Sort sort);
	List<Infraccione> findByDominioContaining(String dominio, Sort sort);
	List<Infraccione> findByCausaContaining(String causa, Sort sort);
	
	@Query(value = "SELECT * FROM infracciones ORDER BY id DESC LIMIT 1", nativeQuery = true)
	Optional<Infraccione> findByLastCausa();
}
