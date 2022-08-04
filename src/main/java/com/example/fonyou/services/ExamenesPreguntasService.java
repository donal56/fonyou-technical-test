package com.example.fonyou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.ExamenPreguntaDAO;
import com.example.fonyou.dto.ExamenPregunta;

/**
 * @author Doni, 03/08/2022 21:16:41
 *
 */
@Service
public class ExamenesPreguntasService {

	@Autowired
	private ExamenPreguntaDAO examenPreguntaDAO;
	
	@Transactional
	public Integer save(ExamenPregunta examenPregunta) {
		return examenPreguntaDAO.insert(examenPregunta);
	}
}
