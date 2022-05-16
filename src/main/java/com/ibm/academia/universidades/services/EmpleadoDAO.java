package com.ibm.academia.universidades.services;

import com.ibm.academia.universidades.entities.Persona;
import com.ibm.academia.universidades.enums.TipoEmpleado;


public interface EmpleadoDAO extends PersonaDAO {

	public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
