package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.Estudiante;

/**
 * @author Doni, 02/08/2022 23:12:27
 *
 */
@Repository
public class EstudianteDAO extends BaseDAO {

	public Integer insert(Estudiante estudiante) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(estudiante);
		KeyHolder keyHolder = this.simpleJdbcInsert
				            .withTableName("estudiantes")
				            .usingGeneratedKeyColumns("id_estudiante")
				            .executeAndReturnKeyHolder(sqlParameterSource);
		
		return keyHolder.getKey().intValue();
	}
}
