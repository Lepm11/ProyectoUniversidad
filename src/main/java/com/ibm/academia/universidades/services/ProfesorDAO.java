package com.ibm.academia.universidades.services;

import com.ibm.academia.universidades.models.entities.Persona;

public interface ProfesorDAO extends PersonaDAO {
	public Iterable<Persona> findProfesoresByCarrera(String nombre);

}
