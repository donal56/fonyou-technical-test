package com.example.fonyou.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Doni, 02/08/2022 23:10:56
 *
 */
@Getter
@Setter
public class Examen {

	private Integer idExamen;
	@NotNull
	@Size(max = 255)
	private String examen;
	@NotNull
	private Integer puntajeTotal;
	private List<ExamenPregunta> preguntas;
	
}
