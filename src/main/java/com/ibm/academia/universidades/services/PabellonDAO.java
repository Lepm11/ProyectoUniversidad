package com.ibm.academia.universidades.services;

import com.ibm.academia.universidades.models.entities.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

	public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);
	public Iterable<Pabellon> findPabellonesByNombre(String nombre);
	public Pabellon actualizar(Pabellon pabellonEncontrado, Pabellon pabellon);
}
