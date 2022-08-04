package com.example.fonyou.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.AplicacionExamenEstudiante;

/**
 * @author Doni, 03/08/2022 08:25:26
 *
 */
@Repository
public class AplicacionExamenEstudianteDAO extends BaseDAO {

	public Integer calcularCalificacion(Integer idAplicacionExamenEstudiante) {
		String sql = "SELECT SUM(CASE WHEN epo.correcta = 1 THEN ep.puntaje ELSE 0 END) " + 
						"FROM aplicaciones_examenes_respuestas aer " + 
						"INNER JOIN aplicaciones_examenes_estudiantes aee ON aee.id_aplicacion_examen_estudiante = aer.id_aplicacion_examen_estudiante " + 
						"INNER JOIN examenes_preguntas ep ON ep.id_examen_pregunta = aer.id_examen_pregunta " + 
						"INNER JOIN examenes_preguntas_opciones epo ON epo.id_examen_pregunta_opcion = aer.id_examen_pregunta_opcion " + 
						"WHERE aer.id_aplicacion_examen_estudiante = :id_aplicacion_examen_estudiante";

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id_aplicacion_examen_estudiante", idAplicacionExamenEstudiante);
		
		return this.namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
	}
	
	public Integer insert(AplicacionExamenEstudiante aplicacionEstudianteExamen) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(aplicacionEstudianteExamen);
		KeyHolder keyHolder = this.simpleJdbcInsert
				            .withTableName("aplicaciones_examenes_estudiantes")
				            .usingGeneratedKeyColumns("id_aplicacion_examen_estudiante", "puntuacion")
				            .executeAndReturnKeyHolder(sqlParameterSource);

		return keyHolder.getKey().intValue();
	}
	
	public Boolean updateCalificacion(Integer idAplicacionExamenEstudiante, Integer calificacion) {
		String sql = 	"UPDATE aplicaciones_examenes_estudiantes SET calificacion = :calificacion " + 
						"WHERE id_aplicacion_examen_estudiante = :id_aplicacion_examen_estudiante";
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id_aplicacion_examen_estudiante", idAplicacionExamenEstudiante)
				.addValue("calificacion", calificacion);
		
		Integer rows = this.namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		return rows == 1;
	}
}
