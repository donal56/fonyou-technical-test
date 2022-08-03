package com.example.fonyou.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fonyou.dto.AplicacionExamenRespuesta;

/**
 * @author Doni, 03/08/2022 08:33:41
 *
 */
@Repository
public class AplicacionExamenRespuestaDAO {
	@Autowired
	private DataSource jdbcTemplate;

	public List<AplicacionExamenRespuesta> findAllByAplicacionExamenEstudiante(Integer idAplicacionExamenEstuadiante) {
		return null;
	}
	
	public Boolean insert(AplicacionExamenRespuesta aplicacionExamenRespuesta) {
		return true;
	}
}
