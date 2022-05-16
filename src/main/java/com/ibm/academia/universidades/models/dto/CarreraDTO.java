package com.ibm.academia.universidades.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/* NO ES ENTIDAD ES UNA CLASE*/
public class CarreraDTO {
	
	private Integer id;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede ser vacio")
	private String nombre;
	 
	@Positive(message = "Debe ser mayor a cero")
	private Integer cantidadMaterias;
	
	@Positive(message = "Debe ser mayor a cero")
	private Integer cantidadAnios;

}
