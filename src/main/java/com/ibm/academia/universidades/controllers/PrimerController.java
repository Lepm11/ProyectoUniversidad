package com.ibm.academia.universidades.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi") //Asigna la uri a la endpoint

public class PrimerController {

	@GetMapping
	public String holaString  () {
		return "Creando mi primer Rest API con java y microservicios";
	}
}
