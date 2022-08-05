package com.example.fonyou.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.AplicacionExamenRespuesta;

/**
 * @author Doni, 03/08/2022 08:33:41
 *
 */
@Repository
public class AplicacionExamenRespuestaDAO extends BaseDAO {

	public List<Map<String, Object>> findAllByAplicacionExamenEstudiante(Integer idAplicacionExamen, Integer idEstudiante) {
		String sql = "SELECT ep.examen_pregunta, epo.examen_pregunta_opcion, epo.correcta " + 
						"FROM aplicaciones_examenes_respuestas aer " + 
						"INNER JOIN aplicaciones_examenes_estudiantes aee ON aee.id_aplicacion_examen_estudiante = aer.id_aplicacion_examen_estudiante " + 
						"INNER JOIN examenes_preguntas ep ON ep.id_examen_pregunta = aer.id_examen_pregunta " + 
						"INNER JOIN examenes_preguntas_opciones epo ON epo.id_examen_pregunta_opcion = aer.id_examen_pregunta_opcion " + 
						" 	AND epo.id_examen_pregunta = aer.id_examen_pregunta " + 
						"WHERE aee.id_aplicacion_examen = :id_aplicacion_examen " + 
							"AND aee.id_estudiante = :id_estudiante";
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id_aplicacion_examen", idAplicacionExamen)
				.addValue("id_estudiante", idEstudiante);
		
		return this.namedParameterJdbcTemplate.queryForList(sql, sqlParameterSource);
	}
	
	public Integer insert(AplicacionExamenRespuesta aplicacionExamenRespuesta) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(aplicacionExamenRespuesta);
		KeyHolder keyHolder = prepareInsert("aplicaciones_examenes_respuestas")
					            .usingGeneratedKeyColumns("id_aplicacion_examen_respuesta")
								.executeAndReturnKeyHolder(sqlParameterSource);

		return keyHolder.getKey().intValue();
	}
	
	public void validar(Integer idAplicacionExamenEstudiante) {
		String sql = "SELECT validar_respuestas(:idAplicacionExamenEstudiante)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("idAplicacionExamenEstudiante", idAplicacionExamenEstudiante);
		this.namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
	}
}
