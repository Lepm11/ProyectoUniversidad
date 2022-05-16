package com.ibm.academia.universidades.services;

import java.util.Optional;

import com.ibm.academia.universidades.entities.Aula;
import com.ibm.academia.universidades.enums.Pizarron;

public interface AulaDAO extends GenericoDAO<Aula>{

		Iterable<Aula> findAulasByTipoPizarron(Pizarron tipoPizarron);
		Iterable<Aula> findAulasByPabellonNombre(String nombre);
		Optional<Aula> findAulaByNumeroAula(Integer numeroAula);
}
