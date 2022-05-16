package com.ibm.academia.universidades.services;

import com.ibm.academia.universidades.enums.TipoEmpleado;
import com.ibm.academia.universidades.models.entities.Persona;


public interface EmpleadoDAO extends PersonaDAO {

	public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
