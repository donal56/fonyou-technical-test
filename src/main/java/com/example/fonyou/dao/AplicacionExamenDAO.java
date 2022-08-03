package com.example.fonyou.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.AplicacionExamen;

/**
 * @author Doni, 03/08/2022 08:25:02
 *
 */
@Repository
public class AplicacionExamenDAO {

	@Autowired
	private DataSource jdbcTemplate;
	
	public Boolean insert(AplicacionExamen aplicacionExamen) {
		return true;
	}
}
