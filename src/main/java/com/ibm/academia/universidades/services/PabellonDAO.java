package com.ibm.academia.universidades.services;

import com.ibm.academia.universidades.entities.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

	public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);
	public Iterable<Pabellon> findPabellonesByNombre(String nombre);
}
