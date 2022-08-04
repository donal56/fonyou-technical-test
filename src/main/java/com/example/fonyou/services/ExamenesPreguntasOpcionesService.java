package com.example.fonyou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.ExamenPreguntaOpcionDAO;
import com.example.fonyou.dto.ExamenPreguntaOpcion;

/**
 * @author Doni, 03/08/2022 21:16:49
 *
 */
@Service
public class ExamenesPreguntasOpcionesService {

	@Autowired
	private ExamenPreguntaOpcionDAO examenPreguntaOpcionDAO;
	
	@Transactional
	public Integer save(ExamenPreguntaOpcion examenPreguntaOpcion) {
		return examenPreguntaOpcionDAO.insert(examenPreguntaOpcion);
	}
}
