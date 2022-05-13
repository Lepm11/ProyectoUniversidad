package com.ibm.academia.universidades.services;

import java.util.Optional;

import com.ibm.academia.universidades.entities.Persona;
import com.ibm.academia.universidades.repositories.PersonaRepository;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO{

	public PersonaDAOImpl(PersonaRepository repository) {
		super(repository);
	}

	@Override
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
		
		return repository.buscarPorNombreYApellido(nombre, apellido);
	}

	@Override
	public Optional<Persona> buscarPorDni(String dni) {
		return repository.buscarPorDni(dni);
	}

	@Override
	public Iterable<Persona> buscarPersonaPorapellido(String apellido) {
		return repository.buscarPersonaPorapellido(apellido);
	}

}
