package com.ibm.academia.universidades.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.universidades.datos.DatosDummy;
import com.ibm.academia.universidades.entities.Carrera;

@DataJpaTest
public class CarreraRepositoryTest {

	@Autowired
	private CarreraRepository carreraRepository;
	
	
	@Test
	@DisplayName("Test: Busca carreras por nombre")
	void findCarrerasByNombreContains(String nombre) {
		//Given
		carreraRepository.save(DatosDummy.carrera01());
		carreraRepository.save(DatosDummy.carrera02());
		carreraRepository.save(DatosDummy.carrera03());
		
		//When
		
		Iterable<Carrera> expectedIterable = carreraRepository.findCarrerasByNombreContains("sistemas");
				
		//Then
		System.out.println(((List<Carrera>) expectedIterable));
		assertThat(((List<Carrera>) expectedIterable).size() == 0).isTrue();
	}
	@Test
	@Disabled
	void findCarrerasByNombreContainsIgnoreCase(String nombre) {
		
	}
	@Test
	@Disabled
	void findCarrerasByCantidadAniosAfter(Integer cantidadAnios){
		
	}

}
