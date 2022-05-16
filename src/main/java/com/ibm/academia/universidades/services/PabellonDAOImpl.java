package com.ibm.academia.universidades.services;

import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.universidades.entities.Pabellon;
import com.ibm.academia.universidades.repositories.PabellonRepository;

public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon,PabellonRepository> implements PabellonDAO {

	public PabellonDAOImpl(PabellonRepository repository) {
		super(repository);
		}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad) {
		return repository.findPabellonesByDireccionLocalidad(localidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findPabellonesByNombre(String nombre) {
		return repository.findPabellonesByNombre(nombre);
	}
	

}
