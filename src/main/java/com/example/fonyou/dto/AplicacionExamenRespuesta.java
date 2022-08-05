package com.example.fonyou.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 03/08/2022 08:32:14
 *
 */
@Getter
@Setter
public class AplicacionExamenRespuesta {

	private Integer idAplicacionExamenRespuesta;
	private Integer idAplicacionExamenEstudiante;
	@NotNull
	private Integer idExamenPregunta;
	@NotNull
	private Integer idExamenPreguntaOpcion;
	
}
