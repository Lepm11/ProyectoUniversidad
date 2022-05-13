package com.ibm.academia.universidades.services;

import java.util.Optional;

import com.ibm.academia.universidades.entities.Persona;

public interface PersonaDAO extends GenericoDAO<Persona>{

	public Optional<Persona> buscarPorNombreYApellido(String nombre,String apellido);
	public Optional<Persona> buscarPorDni(String dni);
	public Iterable<Persona> buscarPersonaPorapellido(String apellido);
	
}

