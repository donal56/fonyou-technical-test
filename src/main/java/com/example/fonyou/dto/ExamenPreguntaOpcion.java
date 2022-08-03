package com.example.fonyou.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 02/08/2022 23:12:08
 *
 */
@Getter
@Setter
public class ExamenPreguntaOpcion {

	private Integer idExamenPreguntaOpcion;
	@NotNull
	private Integer idExamenPregunta;
	@NotNull
	private Integer orden;
	@Size(max= 64)
	private String inciso;
	@NotNull
	@Size(max= 255)
	private String opcion;
	@NotNull
	@Max(1)
	@Min(0)
	private Integer correcta;

}
