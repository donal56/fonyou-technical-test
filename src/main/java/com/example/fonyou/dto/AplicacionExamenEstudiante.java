package com.example.fonyou.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Integer idAplicacionExamen;
	@NotNull
	private Integer idEstudiante;
	private Integer puntuacion;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime fechaAplicacion;
}
