package com.ibm.academia.universidades.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.universidades.exceptions.NotFoundException;
import com.ibm.academia.universidades.models.entities.Carrera;
import com.ibm.academia.universidades.models.entities.Persona;
import com.ibm.academia.universidades.services.AlumnoDAO;
import com.ibm.academia.universidades.services.CarreraDAO;
import com.ibm.academia.universidades.services.PersonaDAO;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	@Qualifier("alumnoDAOImpl")
	private PersonaDAO alumnoDao;
	
	@Autowired
	private CarreraDAO carreraDao;
	
	/**
	 *  Endpoint para crear un objeto Persona de tipo alumno
	 * @param alumno Objeto alumno con la información a crear.
	 * @return Retorna un objeto Persona de tipo alumno con código httpstatus 201;
	 * @author LEPM 13/05/22
	 */
	@PostMapping("/poste")
	public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno){
		Persona alumnoGuardado = alumnoDao.guardar(alumno);
		
		return new ResponseEntity<Persona>(alumnoGuardado,HttpStatus.CREATED);
		
	}
	/***
	 * Endpoint para listar alumnos
	 * @return
	 * @author LEPM
	 */
	@GetMapping("/alumnos/lista")
	public ResponseEntity<?> obtenerTodos(){
		List<Persona> alumnos = (List<Persona>) alumnoDao.buscarTodos();
		if (alumnos.isEmpty()) {
			throw new NotFoundException("No existen alumnos");
		}
		
		return new ResponseEntity<List<Persona>> (alumnos,HttpStatus.OK);
	}
	
	/***
	 * 
	 * @param alumnoId
	 * @return
	 */
	@GetMapping("/alumnoId/{alumnoId}")
	public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer alumnoId){
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		if (!oAlumno.isPresent()) {
			throw new NotFoundException(String.format("Alumno con id %d no existe",alumnoId));			
		}
		
		return new ResponseEntity<Persona>(oAlumno.get(),HttpStatus.OK);
	}
	/***
	 * 
	 * @param alumnoId
	 * @param alumno
	 * @return
	 */
	@PutMapping("/upd/alumnoId/{alumnoId}")
	public ResponseEntity<?> actualizarAlumno(@PathVariable Integer alumnoId,@RequestBody Persona alumno){
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		if (!oAlumno.isPresent()) {
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));	
		}
		Persona alumnoActualizado =((AlumnoDAO)alumnoDao).actualizar(oAlumno.get(),alumno);
		return new ResponseEntity<Persona> (alumnoActualizado,HttpStatus.OK);
	}
	
	
	/***
	 * 
	 * @param alumnoId
	 * @return
	 */
	@DeleteMapping("/alumnoId/{AlumnoI}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId){
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		if (!oAlumno.isPresent()) {
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
		}
		alumnoDao.eliminarPorId(alumnoId);
		
		return new ResponseEntity<String>("Alumno ID:"+ alumnoId+ "se elimino satisfactoriamente",HttpStatus.NO_CONTENT);	
	}
	
	@PutMapping("/alumnoId/{alumnoId}/carrera/{carreraId}")
	public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId,@PathVariable Integer alumnoId){
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		if (!oAlumno.isPresent()) {
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
		}
		
		Optional<Carrera> oCarrera  = carreraDao.buscarPorId(carreraId);
		if (!oCarrera.isPresent()) {
			throw new NotFoundException(String.format("la carrera con ID %d no existe", carreraId));
		}
		
		Persona alumno = ((AlumnoDAO)alumnoDao).asociarCarreraAlumno(oAlumno.get(),oCarrera.get());
		return new ResponseEntity<Persona> (alumno,HttpStatus.OK);
	}
	
}
