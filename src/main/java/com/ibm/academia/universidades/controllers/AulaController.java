package com.ibm.academia.universidades.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.universidades.entities.Aula;
import com.ibm.academia.universidades.exceptions.NotFoundException;
import com.ibm.academia.universidades.services.AulaDAO;

@RestController
@RequestMapping("/aula")
public class AulaController {
	@Autowired
	private AulaDAO aulaDAO;
	
	@PostMapping
	public ResponseEntity<?> guardarAula(@RequestBody Aula aula)
	{
		Aula aulaGuardada = aulaDAO.guardar(aula);
		
		return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
	
	}
	
	@GetMapping("/aulas/lista")
	public ResponseEntity<?> obtenerTodos()
	{
		List<Aula> aulas = (List<Aula>) aulaDAO.buscarTodos();
		
		if(aulas.isEmpty())
			throw new NotFoundException("No existen aulas");
		return new ResponseEntity<List<Aula>>(aulas, HttpStatus.OK);
	}
	
	@GetMapping("/aulaId/{aulaId}")
	public ResponseEntity<?> obtenerAulaPorId(@PathVariable Integer aulaId)
	{
		Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);
		
		if(!oAula.isPresent())
			throw new NotFoundException(String.format("Aula con id %d no existe", aulaId));
		return new ResponseEntity<Aula>(oAula.get(),HttpStatus.OK);
	}
	
	@PutMapping("/upd/aulaId/{aulaId}")
	public ResponseEntity<?> actualizarAula(@PathVariable Integer aulaId, @RequestBody Aula aula)
	{
		Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);
		
		if(!oAula.isPresent())
			throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));
		
		Aula aulaActualizada = ((AulaDAO)aulaDAO).actualizar(oAula.get(), aula);
		return new ResponseEntity<Aula>(aulaActualizada, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/aulaId/{aulaId}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Integer aulaId)
	{
		
		Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);
		
		if(!oAula.isPresent())
			throw new NotFoundException(String.format("El aula con ID: %d no existe", aulaId));
		
		aulaDAO.eliminarPorId(oAula.get().getId());
		return new ResponseEntity<String>("Aula ID: " + aulaId + " se eliminó satisfactoriamente", HttpStatus.NO_CONTENT);
	}

}
