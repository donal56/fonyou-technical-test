package com.example.fonyou.dto;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 02/08/2022 23:11:08
 *
 */
@Getter
@Setter
public class AplicacionExamen {

	private Integer idAplicacionExamen;
	@NotNull
	private Integer idExamen;
	@NotNull
	private Date fechaAplicacion;	//UTC
	private List<AplicacionExamenEstudiante> estudiantes;
	
}
