package com.ibm.academia.universidades.services;

import java.util.Optional;

import com.ibm.academia.universidades.enums.Pizarron;
import com.ibm.academia.universidades.models.entities.Aula;

public interface AulaDAO extends GenericoDAO<Aula>{

		public Iterable<Aula> findAulasByTipoPizarron(Pizarron tipoPizarron);
		public Iterable<Aula> findAulasByPabellonNombre(String nombre);
		public Optional<Aula> findAulaByNumeroAula(Integer numeroAula);
		public Aula actualizar(Aula aulaEncontrada,Aula aula);
}
