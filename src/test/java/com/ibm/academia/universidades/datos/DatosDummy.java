package com.ibm.academia.universidades.datos;

import com.ibm.academia.universidades.models.entities.Carrera;

public class DatosDummy {
	
	//el static sirve para
	
	public static Carrera carrera01() {
		
		return new Carrera(null,"Ingenieria en sistemas",50,5);
	}
	
	public static Carrera carrera02() {
		return new Carrera(null,"Licenciatura en sistemas",45,4);

	}
	public static Carrera carrera03() {
		return new Carrera(null,"Ingenieria industrial",60,5);

	}
	
	
	
}
