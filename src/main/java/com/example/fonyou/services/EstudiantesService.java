package com.example.fonyou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fonyou.dao.EstudianteDAO;
import com.example.fonyou.dto.Estudiante;

/**
 * @author Doni, 03/08/2022 21:16:27
 *
 */
@Service
public class EstudiantesService {

	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@Transactional
	public Integer save(Estudiante estudiante) {
		return estudianteDAO.insert(estudiante);
	}
}
