package com.ibm.academia.universidades;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.universidades.models.entities.Alumno;
import com.ibm.academia.universidades.models.entities.Carrera;
import com.ibm.academia.universidades.models.entities.Persona;
import com.ibm.academia.universidades.services.AlumnoDAO;
import com.ibm.academia.universidades.services.CarreraDAO;
import com.ibm.academia.universidades.services.PersonaDAO;

@Component
public class AlumnosComandos implements CommandLineRunner{
	@Autowired
	private CarreraDAO carreaDao;
	
	@Autowired
	@Qualifier("alumnoDAOImpl")
	private PersonaDAO personaDao;
	
	@Autowired
	private AlumnoDAO alumnoDao;

	@Override
	public void run(String... args) throws Exception {
		
		/*Optional<Carrera> sistemas = carreaDao.buscarPorId(1);
		Iterable<Persona> alumnosIterable = personaDao.buscarTodos();
		alumnosIterable.forEach(alumno-> ((Alumno)alumno).setCarrera(sistemas.get()));
		alumnosIterable.forEach(alumno-> personaDao.guardar(alumno));
	*/
		/*Optional<Persona> alumno = alumnoDao.buscarPorId(1);
		Optional<Persona> personaDni = personaDao.buscarPorDni(alumno.get().getDni());
		System.out.println("DNI:::: "+ personaDni.toString());*/
	}

}
