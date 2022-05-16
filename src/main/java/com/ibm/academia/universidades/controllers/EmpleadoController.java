package com.ibm.academia.universidades.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.universidades.exceptions.NotFoundException;
import com.ibm.academia.universidades.models.entities.Persona;
import com.ibm.academia.universidades.services.PersonaDAO;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	@Qualifier("empleadoDAOImpl")
	private PersonaDAO empleadoDao;
	
	@PostMapping("/post")
	public ResponseEntity<?> crearEmpleado(@RequestBody Persona empleado)
	{
		Persona empleadoGuardado = empleadoDao.guardar(empleado);
		return new ResponseEntity<Persona>(empleadoGuardado,HttpStatus.CREATED);
	}
	
	@GetMapping("/empleados/lista")
	public ResponseEntity<?> obtenerEmpleados()
	{
		List<Persona> empleados = (List<Persona>) empleadoDao.buscarTodos();
		
		if(empleados.isEmpty())
			throw new NotFoundException("No existen empleados");
		return new ResponseEntity<List<Persona>>(empleados, HttpStatus.OK);	
	}

}
