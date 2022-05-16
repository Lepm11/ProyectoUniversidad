package com.ibm.academia.universidades.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.universidades.entities.Aula;
import com.ibm.academia.universidades.enums.Pizarron;
import com.ibm.academia.universidades.repositories.AulaRepository;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

	@Autowired
	public AulaDAOImpl(AulaRepository repository) {
		super(repository);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulasByTipoPizarron(Pizarron tipoPizarron) {
		return repository.findAulasByTipoPizarron(tipoPizarron);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
		return repository.findAulasByPabellonNombre(nombre);
	}

	@Override
	public Optional<Aula> findAulaByNumeroAula(Integer numeroAula) {
		return findAulaByNumeroAula(numeroAula);
	}


	
	
}
