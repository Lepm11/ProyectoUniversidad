package com.ibm.academia.universidades.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.universidades.exceptions.BadRequestExceptions;
import com.ibm.academia.universidades.exceptions.NotFoundException;

@ControllerAdvice
public class UniversidadRestException {
	
	@ExceptionHandler(value = BadRequestExceptions.class)
	public ResponseEntity<Object> formatoInvalidoException(BadRequestExceptions exceptions){
		Map<String, Object> respuestaMap = new HashMap<String,Object>();
		respuestaMap.put("error", exceptions.getMessage());
		return new ResponseEntity<>(respuestaMap,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<?> noExisteException(NotFoundException exception){
		Map<String, Object> respuesta = new HashMap<String,Object>();
		respuesta.put("error", exception.getMessage());
		
		return new ResponseEntity<>(respuesta,HttpStatus.NOT_FOUND);
	}

}
