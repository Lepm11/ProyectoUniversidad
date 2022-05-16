package com.ibm.academia.universidades.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.universidades.exceptions.BadRequestExceptions;
import com.ibm.academia.universidades.exceptions.NotFoundException;
import com.ibm.academia.universidades.mapper.CarreraMapper;
import com.ibm.academia.universidades.models.dto.CarreraDTO;
import com.ibm.academia.universidades.models.entities.Carrera;
import com.ibm.academia.universidades.services.CarreraDAO;

@RestController
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private CarreraDAO carreraDao;
	
	@GetMapping("/Lista/carreras")
	public List<Carrera> buscarTodaS(){
		List<Carrera> carreras= (List<Carrera>)carreraDao.buscarTodos();
		//Empty es unicamente para listas
		if (carreras.isEmpty()) {
			throw new BadRequestExceptions("No existen carreras");
		}
		return carreras;
	}
	
	@GetMapping("/id/{carreraId}")
	public Carrera buscarCArreraPorId(@PathVariable(value = "carreraId") Integer carreraId) {
		Optional<Carrera> oCarreraOptional = carreraDao.buscarPorId(carreraId);
		//isPresent() unicamente para objetos tipo optional
		if(!oCarreraOptional.isPresent()) {
			throw new BadRequestExceptions(String.format("La carrera con ID: %d no existe", carreraId));
		}
		return oCarreraOptional.get();
	}
	
	@PostMapping("/poste")
	public ResponseEntity<?> guardarCarrera(@Valid @RequestBody Carrera carrera,BindingResult result){
		
		Map<String, Object> validaciones = new HashMap<String,Object>();
		if(result.hasErrors()) {
			List<String> listaErroresList = result.getFieldErrors()
					.stream()
					.map(errores-> "Campo: '"+ errores.getField()+ "' " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			
			validaciones.put("lista Errores:", listaErroresList);
			return new ResponseEntity<Map<String, Object>>(validaciones,HttpStatus.BAD_REQUEST);
		}
		
		
		Carrera carreraGuardada = carreraDao.guardar(carrera);
		
		return new ResponseEntity<Carrera> (carreraGuardada,HttpStatus.CREATED);
	}
	
	
	/**
	 * Endpoint para actualizar un objeto de tipo carrera
	 * @param carreraId, parametro para buscar la carrera
	 * @param carrera, objeto con la información a modificar
	 * @return retorna un objeto de tipo carrera con la informaicón actualizada
	 * @NotFoundException en caso de que falle actualizando el objeto carrera
	 * 
	 * @author LEPM 13/05/2022
	 * 
	 */
	@PutMapping("/upd/carreraId/{carreraId}")
	public ResponseEntity<?> actualizarCarrera(@PathVariable Integer carreraId,@RequestBody Carrera carrera){
		Optional<Carrera> oCarrera = carreraDao.buscarPorId(carreraId);
		if (!oCarrera.isPresent()) {
			throw new NotFoundException(String.format("La carrera con ID :%d no existe", carreraId));
		}
		Carrera carreraActualizada = carreraDao.actualizar(oCarrera.get(),carrera);
		return new ResponseEntity<Carrera> (carreraActualizada,HttpStatus.OK);
	}
	
	@DeleteMapping("/carreraId/{carreraId}")
	public ResponseEntity<?> eliminaCarrera(@PathVariable Integer carreraId){
		Map<String, Object> respuesta = new HashMap<String,Object>();
		Optional<Carrera> carrera = carreraDao.buscarPorId(carreraId);
		if (!carrera.isPresent()) {
			throw new NotFoundException(String.format("La carrera con ID: %d no existe", HttpStatus.NO_CONTENT));
		}
		carreraDao.eliminarPorId(carreraId);
		respuesta.put("OK", "Carrera ID: "+ carreraId + " eliminada correctamente");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.ACCEPTED);
	}
	/**
	 *  EndPoint para consultar todas las carreras
	 *  
	 * @return Retorna una lista de carreras en DTO
	 * @NotFoundException En caso de que no encuentre ningun eemento en la base de datos
	 * @author LEPM
	 */
	@GetMapping("/carreras/dto")
	public ResponseEntity<?> obtenerCarrerasDTO(){
		List<Carrera> carreras = (List<Carrera>) carreraDao.buscarTodos();
		if (carreras.isEmpty()) {
			throw  new NotFoundException("No existen carreras en la base de datos");
		}
		List<CarreraDTO> listaCarreras = carreras
				.stream()
				.map(CarreraMapper::mapCarrera)
				.collect(Collectors.toList());
		return new ResponseEntity<List<CarreraDTO>> (listaCarreras,HttpStatus.OK); 
	}

}
