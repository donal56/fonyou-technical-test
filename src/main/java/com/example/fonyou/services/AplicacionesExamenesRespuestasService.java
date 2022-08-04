package com.example.fonyou.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.AplicacionExamenRespuestaDAO;
import com.example.fonyou.dto.AplicacionExamenRespuesta;

/**
 * @author Doni, 03/08/2022 21:16:06
 *
 */
@Service
public class AplicacionesExamenesRespuestasService {

	@Autowired
	private AplicacionExamenRespuestaDAO aplicacionExamenRespuestaDAO;
	
	public List<Map<String, Object>> findAllByAplicacionExamenEstudiante(Integer idAplicacionExamen, Integer idEstudiante) {
		return aplicacionExamenRespuestaDAO.findAllByAplicacionExamenEstudiante(idAplicacionExamen, idEstudiante);
	}
	
	@Transactional
	public Integer save(AplicacionExamenRespuesta aplicacionExamenRespuesta) {
		return aplicacionExamenRespuestaDAO.insert(aplicacionExamenRespuesta);
	}
}
