package com.ibm.academia.universidades.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.universidades.enums.Pizarron;
import com.ibm.academia.universidades.models.entities.Aula;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer>{

	@Query("select a from Aula a where a.pizarron = ?1")
	public Iterable<Aula> findAulasByTipoPizarron(Pizarron tipoPizarron);
	
	@Query(value = "select a.* from universidad2.aulas a inner join universidad2.pabellones ON pabellones.id = a.pabellon_id where pabellones.nombre_pabellon =:nombre ", nativeQuery = true)
	public Iterable<Aula> findAulasByPabellonNombre(String nombre);
	
	@Query("select a from  Aula a where a.numeroAula = ?1")
	public Optional<Aula> findAulaByNumeroAula(Integer numeroAula);

}
