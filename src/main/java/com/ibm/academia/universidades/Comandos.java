package com.ibm.academia.universidades;

import java.util.List;
import java.util.Optional;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.universidades.models.entities.Carrera;
import com.ibm.academia.universidades.models.entities.Persona;
import com.ibm.academia.universidades.services.AlumnoDAO;
import com.ibm.academia.universidades.services.CarreraDAO;
import com.ibm.academia.universidades.services.PersonaDAO;

@Component
public class Comandos implements CommandLineRunner {

	@Autowired
	private CarreraDAO carreraDao;
	
	@Override
	public void run(String... args) throws Exception {
		//Consultas repositorios
		
		/*Carrera finanzasCarrera = new Carrera(null, "Ingenieria industrial", 60, 5);
		Carrera carreraGuardada = carreraDAO.guardar(finanzasCarrera);
		System.out.println(carreraGuardada.toString());
		Carrera carrera = null;
		Optional<Carrera> oCarrera=carreraDAO.buscarPorId(1);
		if(oCarrera.isPresent()) {
			carrera = oCarrera.get();
			System.out.println(carrera.toString());
		}else {
			System.out.println("Carrera no encontrada");
		}
		
		carrera.setCantidadanios(7);
		carrera.setCantidadMaterias(66);
		carreraDAO.guardar(carrera);
		//a partir de java8
		
		System.out.println(carreraDAO.buscarPorId(99).orElse(new Carrera()).toString());
		carreraDAO.eliminarPorId(1);
		System.out.println(carreraDAO.buscarPorId(1).orElse(new Carrera()).toString());
*/
		/*Carrera IngAlimentos = new Carrera(null,"Ingenieria en Alimentos",60,5);
		Carrera IngElectronica =  new Carrera(null,"Ingenieria Electronica", 55, 5);
		Carrera LicSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
		Carrera LicTurismo = new Carrera(null,"Licencuatura en Turismo",42,4);
		Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
		Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos", 33, 3);
		
		
		carreraDAO.guardar(IngAlimentos);
		carreraDAO.guardar(IngElectronica);
		carreraDAO.guardar(LicSistemas);
		carreraDAO.guardar(LicTurismo);
		carreraDAO.guardar(licYoga);
		carreraDAO.guardar(licRecursos);*/
		
		
		/*Optional<Carrera> ingSistemasOptional = carreraDao.buscarPorId(4);
		Iterable<Persona> alumnosIterable = personaDao.buscarTodos();
		alumnosIterable.forEach(alumno-> ((Alumno)alumno).setCarrera(ingSistemasOptional.get()));
		alumnosIterable.forEach(alumno-> personaDao.guardar(alumno));*/ 
		
		/*Optional<Carrera> ingSistemasOptional = carreraDao.buscarPorId(3);
		Iterable<Persona> alumnosIterable =((AlumnoDAO) personaDao).buscarAlumnoPorNombreCarrera(ingSistemasOptional.get().getNombre());
		alumnosIterable.forEach(System.out::println);*/
		/*System.out.println("PRUEBAS");
		List<Carrera> carreras = (List<Carrera>)carreraDao.findCarrerasByNombreContains("sistemas");
		carreras.forEach(System.out::println);*/
		/*List<Carrera> carrerasIgnoreCase1 = (List<Carrera>) carreraDao.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
		System.out.println("PRIMER CASO");
		carrerasIgnoreCase1.forEach(System.out::println);
		
		List<Carrera> carrerasIgnoreCase22 = (List<Carrera>) carreraDao.findCarrerasByNombreContainsIgnoreCase("sistemas");
		System.out.println("SEGUNDO CASO");
		carrerasIgnoreCase22.forEach(System.out::println);
		
		List<Carrera> carrerasPorAnio = (List<Carrera>) carreraDao.findCarrerasByCantidadAniosAfter(3);
		carrerasPorAnio.forEach(System.out::println);*/
		/*
		Optional<Persona> persona = personaDao.buscarPorId(1);
		System.out.println(persona.toString());
		*/
		
		
		
	}

}
