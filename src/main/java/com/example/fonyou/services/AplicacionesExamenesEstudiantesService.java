package com.example.fonyou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.AplicacionExamenEstudianteDAO;
import com.example.fonyou.dto.AplicacionExamenEstudiante;

/**
 * @author Doni, 03/08/2022 21:15:54
 *
 */
@Service
public class AplicacionesExamenesEstudiantesService {
	
	@Autowired
	private AplicacionExamenEstudianteDAO aplicacionExamenEstudianteDAO;
	
	@Transactional
	public Integer calificar(Integer idAplicacionExamenEstudiante) {
		Integer calificacion = aplicacionExamenEstudianteDAO.calcularCalificacion(idAplicacionExamenEstudiante);
		Boolean exito = aplicacionExamenEstudianteDAO.updateCalificacion(idAplicacionExamenEstudiante, calificacion);
		return exito ? calificacion : null;
	}
	
	@Transactional
	public Integer save(AplicacionExamenEstudiante aplicacionEstudianteExamen) {
		return aplicacionExamenEstudianteDAO.insert(aplicacionEstudianteExamen);
	}
}
