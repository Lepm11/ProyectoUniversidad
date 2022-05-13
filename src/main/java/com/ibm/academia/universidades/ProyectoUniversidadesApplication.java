package com.ibm.academia.universidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibm.academia.universidades.entities.Persona;
import com.ibm.academia.universidades.services.AlumnoDAO;

@SpringBootApplication
public class ProyectoUniversidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUniversidadesApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			/*Direccion direccion =  new Direccion("Caliza","09820","23",null,null,"iztapalapa");
			Alumno alumnoPersona = new Alumno(null, "José", "Pioquinto", "231521", direccion);	
			Persona personaGuardadaPersona = alumnoDAO.guardar(alumnoPersona);
			
			System.out.println(personaGuardadaPersona.toString());
			
			List<Persona> alumnosList = (List<Persona>)alumnoDAO.buscarTodos();
			alumnosList.forEach(System.out::println);
			*/
			System.out.println("RUNNING ");
		};
	}

}
