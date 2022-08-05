package com.example.fonyou.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 02/08/2022 23:10:48
 *
 */
@Getter
@Setter
public class Estudiante {

	private Integer idEstudiante;
	@NotNull
	@Size(max = 255)
	private String nombre;
	@NotNull
	@Size(max = 255)
	private String apellidoPaterno;
	@Size(max = 255)
	private String apellidoMaterno;
	@NotNull
	private Date fechaNacimiento;
	private Integer edad;
	@Size(max = 255)
	@NotNull
	private String ciudad;
	@Size(max = 32)
	@NotNull
	private String zonaHoraria;
	
}
