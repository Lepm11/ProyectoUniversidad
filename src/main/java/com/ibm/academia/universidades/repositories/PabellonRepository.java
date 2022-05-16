package com.ibm.academia.universidades.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ibm.academia.universidades.entities.Pabellon;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {
	public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);
	public Iterable<Pabellon> findPabellonesByNombre(String nombre);

}
