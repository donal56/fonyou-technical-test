package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.AplicacionExamen;

/**
 * @author Doni, 03/08/2022 08:25:02
 *
 */
@Repository
public class AplicacionExamenDAO extends BaseDAO {
	
	public Integer insert(AplicacionExamen aplicacionExamen) {
		
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(aplicacionExamen);
		KeyHolder keyHolder = prepareInsert("aplicaciones_examenes")
					            .usingGeneratedKeyColumns("id_aplicacion_examen")
					            .executeAndReturnKeyHolder(sqlParameterSource);

		return keyHolder.getKey().intValue();
	}
}
