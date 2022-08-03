package com.example.fonyou.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.ExamenPregunta;

/**
 * @author Doni, 03/08/2022 08:25:51
 *
 */
@Repository
public class ExamenPreguntaDAO {
	
	@Autowired
	private DataSource jdbcTemplate;

	public Boolean insert(ExamenPregunta examenPregunta) {
		return true;
	}
}
