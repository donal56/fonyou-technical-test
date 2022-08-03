package com.example.fonyou.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Doni, 02/08/2022 23:10:48
 *
 */
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
	@NotNull
	private Integer edad;
	@Size(max = 255)
	@NotNull
	private String ciudad;
	@Size(max = 32)
	@NotNull
	private String zonaHoraria;
	
}
