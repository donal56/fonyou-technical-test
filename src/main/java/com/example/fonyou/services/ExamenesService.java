package com.example.fonyou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.ExamenDAO;
import com.example.fonyou.dao.ExamenPreguntaDAO;
import com.example.fonyou.dao.ExamenPreguntaOpcionDAO;
import com.example.fonyou.dto.Examen;
import com.example.fonyou.dto.ExamenPregunta;
import com.example.fonyou.dto.ExamenPreguntaOpcion;s

/**
 * @author Doni, 03/08/2022 21:16:16
 *
 */
@Service
public class ExamenesService {
	
	@Autowired
	private ExamenDAO examenDAO;
	@Autowired
	private ExamenPreguntaDAO examenPreguntaDAO;
	@Autowired
	private ExamenPreguntaOpcionDAO examenPreguntaOpcionDAO; 
	
	@Transactional
	public Integer save(Examen examen) {
		Integer idExamen = examenDAO.insert(examen);
		
		for(ExamenPregunta pregunta : examen.getPreguntas()) {
			pregunta.setIdExamen(idExamen);
			Integer idExamenPregunta = examenPreguntaDAO.insert(pregunta);
			
			for(ExamenPreguntaOpcion opcion : pregunta.getOpciones()) {
				opcion.setIdExamenPregunta(idExamenPregunta);
				examenPreguntaOpcionDAO.insert(opcion);
			}
		}
		
		return idExamen;
	}
}
