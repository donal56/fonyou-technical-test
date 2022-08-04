package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.ExamenPreguntaOpcion;

/**
 * @author Doni, 03/08/2022 08:25:58
 *
 */
@Repository
public class ExamenPreguntaOpcionDAO extends BaseDAO {
	
	public Integer insert(ExamenPreguntaOpcion examenPreguntaOpcion) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(examenPreguntaOpcion);
		KeyHolder keyHolder = this.simpleJdbcInsert
				            .withTableName("examenes_preguntas_opciones")
				            .usingGeneratedKeyColumns("id_examen_pregunta_opcion")
							.executeAndReturnKeyHolder(sqlParameterSource);
		
		return keyHolder.getKey().intValue();
	}
}
