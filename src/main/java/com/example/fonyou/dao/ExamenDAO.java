package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
		KeyHolder keyHolder = prepareInsert("examenes")
					            .usingGeneratedKeyColumns("id_examen")
					            .executeAndReturnKeyHolder(sqlParameterSource);
		
		return keyHolder.getKey().intValue();
	}
	
	public void validar(Integer idExamen) {
		String sql = "SELECT validar_examen(:idExamen)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("idExamen", idExamen);
		this.namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
	}
}
