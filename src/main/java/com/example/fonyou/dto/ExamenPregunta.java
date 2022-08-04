package com.example.fonyou.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 02/08/2022 23:11:32
 *
 */
@Getter
@Setter
public class ExamenPregunta {

	private Integer idExamenPregunta;
	@NotNull
	private Integer idExamen;
	@NotNull
	private Integer orden;
	@Size(max= 64)
	private String inciso;
	@NotNull
	@Size(max= 512)
	private String pregunta;
	@NotNull
	private Integer puntaje;
	private List<ExamenPreguntaOpcion> opciones;

}
