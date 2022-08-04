package com.example.fonyou.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 02/08/2022 23:11:22
 *
 */
@Getter
@Setter
public class AplicacionExamenEstudiante {

	private Integer idAplicacionExamenEstudiante;
	@NotNull
	private Integer idAplicacionExamen;
	@NotNull
	private Integer idEstudiante;
	private Integer puntuacion;
}
