package com.example.fonyou.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.ExamenPreguntaOpcion;

/**
 * @author Doni, 03/08/2022 08:25:58
 *
 */
@Repository
public class ExamenPreguntaOpcionDAO {
	
	@Autowired
	private DataSource jdbcTemplate;

	public Boolean insert(ExamenPreguntaOpcion examenPreguntaOpcion) {
		return true;
	}
}
