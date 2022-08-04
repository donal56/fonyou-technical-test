package com.example.fonyou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.AplicacionExamenDAO;
import com.example.fonyou.dao.AplicacionExamenEstudianteDAO;
import com.example.fonyou.dto.AplicacionExamen;
import com.example.fonyou.dto.AplicacionExamenEstudiante;

/**
 * @author Doni, 03/08/2022 21:15:41
 *
 */
@Service
public class AplicacionesExamenesService {

	@Autowired
	private AplicacionExamenDAO aplicacionExamenDAO;
	@Autowired
	private AplicacionExamenEstudianteDAO aplicacionExamenEstudianteDAO;
	
	@Transactional
	public Integer save(AplicacionExamen aplicacionExamen) {
		Integer idAplicacionExamen = aplicacionExamenDAO.insert(aplicacionExamen);
		
		for(AplicacionExamenEstudiante estudiante : aplicacionExamen.getEstudiantes()) {
			estudiante.setIdAplicacionExamen(idAplicacionExamen);
			aplicacionExamenEstudianteDAO.insert(estudiante);
		}
		
		return idAplicacionExamen;
	}
}
