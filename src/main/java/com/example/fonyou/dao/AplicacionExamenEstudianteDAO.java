package com.example.fonyou.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.AplicacionExamenEstudiante;

/**
 * @author Doni, 03/08/2022 08:25:26
 *
 */
@Repository
public class AplicacionExamenEstudianteDAO {

	@Autowired
	private DataSource jdbcTemplate;

	public Integer calificar(Integer idAplicacionExamenEstudiante) {
		return null;
	}
	
	public Boolean insert(AplicacionExamenEstudiante aplicacionEstudianteExamen) {
		return true;
	}
}
