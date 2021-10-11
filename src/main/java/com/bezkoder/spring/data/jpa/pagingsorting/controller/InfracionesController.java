package com.bezkoder.spring.data.jpa.pagingsorting.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.jpa.pagingsorting.model.Infraccione;
import com.bezkoder.spring.data.jpa.pagingsorting.model.Tutorial;
import com.bezkoder.spring.data.jpa.pagingsorting.repository.InfracionesRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class InfracionesController {
	@Autowired
	InfracionesRepository infracionesRepository;
	
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	  }
	
	
	  @GetMapping("/infraciones")
	  public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
	      @RequestParam(required = false) String title,
	      @RequestParam(defaultValue = "dni") String campo,
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "5") int size,
	      @RequestParam(defaultValue = "fecha,desc") String[] sort) {

	    try {
	      List<Order> orders = new ArrayList<Order>();

	      if (sort[0].contains(",")) {
	        // will sort more than 2 fields
	        // sortOrder="field, direction"
	        for (String sortOrder : sort) {
	          String[] _sort = sortOrder.split(",");
	          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
	        }
	      } else {
	        // sort=[field, direction]
	        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
	      }

	      List<Infraccione> infracciones = new ArrayList<Infraccione>();
	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

	      Page<Infraccione> pageTuts;
	      if (title == null)
	        pageTuts = infracionesRepository.findAll(pagingSort);
	      else
	    	  switch (campo) {
	    	  case "dni":
	    		  pageTuts = infracionesRepository.findByDniContaining(title, pagingSort);
	    		  break;
	    	  case "nombre":
	    		  pageTuts = infracionesRepository.findByNombreContaining(title, pagingSort);//findByDniContaining(title, pagingSort);
	    		  break;
	    	  case "acta":
	    		  pageTuts = infracionesRepository.findByActaContaining(title, pagingSort);//findByDniContaining(title, pagingSort);
	    		  break;
	    	  case "dominio":
	    		  pageTuts = infracionesRepository.findByDominioContaining(title, pagingSort);//findByDniContaining(title, pagingSort);
	    		  break;
	    	  default:
	    		  pageTuts = infracionesRepository.findByDniContaining(title, pagingSort);
	    	    break;
	    	}
	          //findByNombreContaining(title, pagingSort);//findByTitleContaining(title, pagingSort);

	      
	      infracciones  = pageTuts.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("tutorials", infracciones );
	      response.put("currentPage", pageTuts.getNumber());
	      response.put("totalItems", pageTuts.getTotalElements());
	      response.put("totalPages", pageTuts.getTotalPages());

	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	    	System.out.println(e);
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	   @GetMapping("/infraciones/{id}")
	  public ResponseEntity<Infraccione> getTutorialById(@PathVariable("id") Long id) {
	    Optional<Infraccione> tutorialData = infracionesRepository.findById(id);//tutorialRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	 @PutMapping("/infraciones/{id}")
	  public ResponseEntity<Infraccione> updateTutorial(@PathVariable("id") Long id, @RequestBody Infraccione tutorial) {
	    Optional<Infraccione> tutorialData = infracionesRepository.findById(id);

	    if (tutorialData.isPresent()) {
	    	Infraccione _tutorial = tutorialData.get();
	    _tutorial.setActa(tutorial.getActa());
	    _tutorial.setFecha(tutorial.getFecha());
	    _tutorial.setNombre(tutorial.getNombre());
	    _tutorial.setDireccion(tutorial.getDireccion());
	    _tutorial.setCodigoPostal(tutorial.getCodigoPostal());
	    _tutorial.setLocalidad(tutorial.getLocalidad());
	    _tutorial.setProvincia(tutorial.getProvincia());
	    _tutorial.setDni(tutorial.getDni());
	    _tutorial.setDescripcion(tutorial.getDescripcion());
	    _tutorial.setLugar(tutorial.getLugar());
	    _tutorial.setVehiculo(tutorial.getVehiculo());
	    _tutorial.setDominio(tutorial.getDominio());
	    _tutorial.setAgente(tutorial.getAgente());
	    _tutorial.setActoResolutorio(tutorial.getActoResolutorio());
	    _tutorial.setFechaResolucion(tutorial.getFechaResolucion());
	    _tutorial.setLeyOrdenanza(tutorial.getLeyOrdenanza());
	    _tutorial.setArticulo(tutorial.getArticulo());
	    _tutorial.setInciso(tutorial.getInciso());
	    _tutorial.setValor(tutorial.getValor());
	    _tutorial.setComentario(tutorial.getComentario());
	    _tutorial.setIntervino(tutorial.getIntervino());
	    _tutorial.setNombreTitular(tutorial.getNombreTitular());
	    _tutorial.setDireccionTitular(tutorial.getDireccion());
	    _tutorial.setLocalidadTitular(tutorial.getLocalidadTitular());
	    _tutorial.setCpTitular(tutorial.getCpTitular());
	    _tutorial.setProvinciaTitular(tutorial.getProvinciaTitular());
	    _tutorial.setDniTitular(tutorial.getDniTitular());
	    _tutorial.setUnidadValor(tutorial.getUnidadValor());
	    
	    
	     
	      return new ResponseEntity<>(infracionesRepository.save(_tutorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PostMapping("/infraciones")
	  public ResponseEntity<Infraccione> createTutorial(@RequestBody Infraccione tutorial) {
	    try {
	      Infraccione _tutorial = new Infraccione();
	      _tutorial.setActa(tutorial.getActa());
		    _tutorial.setFecha(tutorial.getFecha());
		    _tutorial.setNombre(tutorial.getNombre());
		    _tutorial.setDireccion(tutorial.getDireccion());
		    _tutorial.setCodigoPostal(tutorial.getCodigoPostal());
		    _tutorial.setLocalidad(tutorial.getLocalidad());
		    _tutorial.setProvincia(tutorial.getProvincia());
		    _tutorial.setDni(tutorial.getDni());
		    _tutorial.setDescripcion(tutorial.getDescripcion());
		    _tutorial.setLugar(tutorial.getLugar());
		    _tutorial.setVehiculo(tutorial.getVehiculo());
		    _tutorial.setDominio(tutorial.getDominio());
		    _tutorial.setAgente(tutorial.getAgente());
		    _tutorial.setActoResolutorio(tutorial.getActoResolutorio());
		    _tutorial.setFechaResolucion(tutorial.getFechaResolucion());
		    _tutorial.setLeyOrdenanza(tutorial.getLeyOrdenanza());
		    _tutorial.setArticulo(tutorial.getArticulo());
		    _tutorial.setInciso(tutorial.getInciso());
		    _tutorial.setValor(tutorial.getValor());
		    _tutorial.setComentario(tutorial.getComentario());
		    _tutorial.setIntervino(tutorial.getIntervino());
		    _tutorial.setNombreTitular(tutorial.getNombreTitular());
		    _tutorial.setDireccionTitular(tutorial.getDireccion());
		    _tutorial.setLocalidadTitular(tutorial.getLocalidadTitular());
		    _tutorial.setCpTitular(tutorial.getCpTitular());
		    _tutorial.setProvinciaTitular(tutorial.getProvinciaTitular());
		    _tutorial.setDniTitular(tutorial.getDniTitular());
		    _tutorial.setUnidadValor(tutorial.getUnidadValor());
		    
	      return new ResponseEntity<>(infracionesRepository.save(_tutorial), HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @DeleteMapping("/infraciones/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id) {
	    try {
	    	infracionesRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
