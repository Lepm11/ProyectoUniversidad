package com.ibm.academia.universidades.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi") //Asigna la uri a la endpoint

public class PrimerController {
	
	Logger logger = LoggerFactory.getLogger(PrimerController.class);
	@GetMapping("/getting")
	public String holaString  () {
		
		logger.trace("trace log");
		logger.debug("debug log");
		logger.info("Info Log");
		logger.warn("warning log");
		logger.error("Error log");
		return "Creando mi primer Rest API con java y microservicios";

	}
}
