package com.example.fonyou.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * @author Doni, 03/08/2022 22:21:28
 *
 */
public class BaseDAO {
	
	@Autowired
	protected DataSource dataSource;

	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostConstruct
	private void initialize() {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	protected SimpleJdbcInsert prepareInsert(String tabla) {
		return new SimpleJdbcInsert(jdbcTemplate)
	            .withTableName(tabla);
	}
}
