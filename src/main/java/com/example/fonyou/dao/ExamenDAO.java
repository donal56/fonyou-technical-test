package com.example.fonyou.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.Examen;

/**
 * @author Doni, 03/08/2022 08:25:42
 *
 */
@Repository
public class ExamenDAO {
	
	@Autowired
	private DataSource jdbcTemplate;

	public Boolean insert(Examen examen) {
		return true;
	}
}
