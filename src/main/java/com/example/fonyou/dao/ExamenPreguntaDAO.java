package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.ExamenPregunta;

/**
 * @author Doni, 03/08/2022 08:25:51
 *
 */
@Repository
public class ExamenPreguntaDAO extends BaseDAO {
	
	public Integer insert(ExamenPregunta examenPregunta) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(examenPregunta);
		KeyHolder keyHolder = prepareInsert("examenes_preguntas")
					            .usingGeneratedKeyColumns("id_examen_pregunta")
								.executeAndReturnKeyHolder(sqlParameterSource);
		
		return keyHolder.getKey().intValue();
	}
}
