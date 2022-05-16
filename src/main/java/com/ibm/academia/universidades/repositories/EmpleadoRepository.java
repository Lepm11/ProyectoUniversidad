package com.ibm.academia.universidades.repositories;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.academia.universidades.entities.Persona;
import com.ibm.academia.universidades.enums.TipoEmpleado;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository {

	@Query("select e from Persona e where e.tipoEmpleado = ?1")
	public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
