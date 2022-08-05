package com.example.fonyou.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime  fechaAplicacion;	//UTC
	@NotNull
	private List<AplicacionExamenEstudiante> estudiantes;
	
}
