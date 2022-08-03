package com.example.fonyou.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.Estudiante;

/**
 * @author Doni, 02/08/2022 23:12:27
 *
 */
@Repository
public class EstudianteDAO {
	
	@Autowired
	private DataSource jdbcTemplate;

	public Boolean insert(Estudiante estudiante) {
		return true;
	}
}
