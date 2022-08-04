package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.Examen;

/**
 * @author Doni, 03/08/2022 08:25:42
 *
 */
@Repository
public class ExamenDAO extends BaseDAO {
	
	public Integer insert(Examen examen) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(examen);
		KeyHolder keyHolder = this.simpleJdbcInsert
				            .withTableName("examenes")
				            .usingGeneratedKeyColumns("id_examen")
				            .executeAndReturnKeyHolder(sqlParameterSource);
		
		return keyHolder.getKey().intValue();
	}
}
