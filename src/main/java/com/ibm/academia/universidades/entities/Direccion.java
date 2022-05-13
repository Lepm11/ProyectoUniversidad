package com.ibm.academia.universidades.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.print.event.PrintJobAttributeEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Direccion implements Serializable{

	private String nombre;
	private String numero;
	private String codigoPostal;
	private String departamento;
	private String piso;
	private String localidad;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1033585853929675073L;
	
}
