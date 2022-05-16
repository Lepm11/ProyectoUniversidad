package com.ibm.academia.universidades.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.universidades.entities.Persona;
import com.ibm.academia.universidades.enums.TipoEmpleado;
import com.ibm.academia.universidades.repositories.EmpleadoRepository;
import com.ibm.academia.universidades.repositories.PersonaRepository;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {
	
	@Autowired
	public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados") PersonaRepository repository) {
		super(repository);
	}
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
		return ((EmpleadoRepository) repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
	}
	

}
