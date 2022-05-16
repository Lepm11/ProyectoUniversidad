package com.ibm.academia.universidades.controllers;

import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.universidades.exceptions.NotFoundException;
import com.ibm.academia.universidades.models.entities.Persona;
import com.ibm.academia.universidades.services.PersonaDAO;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	
	private PersonaDAO personaDao;
	
	@GetMapping("/nombre-apellido")
	public ResponseEntity<?> buscarPersonaPorNombreYApellido (@RequestParam String nombre, @RequestParam String apellido){
		Optional<Persona> oPersona = personaDao.buscarPorNombreYApellido(nombre, apellido);
		if (!oPersona.isPresent()) {
			throw new NotFoundException(String.format("No se encontró persona con nombre %s y apellido %s", nombre,apellido));	
		}
		return new ResponseEntity<Persona>(oPersona.get(),HttpStatus.OK);
	}
}
