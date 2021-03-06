package com.ibm.academia.universidades.services;

import com.ibm.academia.universidades.models.entities.Carrera;
import com.ibm.academia.universidades.models.entities.Persona;

public interface AlumnoDAO extends PersonaDAO{

	public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
	public Persona actualizar(Persona alumnoEncontrado,Persona alumno);
	public Persona asociarCarreraAlumno(Persona alumno,Carrera carrera);
}
