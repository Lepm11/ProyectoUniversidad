package com.ibm.academia.universidades.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.universidades.models.entities.Pabellon;
import com.ibm.academia.universidades.repositories.PabellonRepository;

@Service
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
	
	@Override
    @Transactional
    public Pabellon actualizar(Pabellon pabellonEncontrado, Pabellon pabellon) {
        Pabellon pabellonActualizado = null;
        pabellonEncontrado.setNombre(pabellon.getNombre());
        pabellonEncontrado.setAulas(pabellon.getAulas());
        pabellonEncontrado.setDireccion(pabellon.getDireccion());
        pabellonActualizado=repository.save(pabellonEncontrado);

        return pabellonActualizado;
    }
	

}
