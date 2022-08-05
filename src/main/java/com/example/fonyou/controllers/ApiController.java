package com.example.fonyou.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fonyou.dto.AplicacionExamen;
import com.example.fonyou.dto.AplicacionExamenEstudiante;
import com.example.fonyou.dto.AplicacionExamenRespuesta;
import com.example.fonyou.dto.Estudiante;
import com.example.fonyou.dto.Examen;
import com.example.fonyou.dto.Respuesta;
import com.example.fonyou.services.AplicacionesExamenesEstudiantesService;
import com.example.fonyou.services.AplicacionesExamenesRespuestasService;
import com.example.fonyou.services.AplicacionesExamenesService;
import com.example.fonyou.services.EstudiantesService;
import com.example.fonyou.services.ExamenesService;

/**
 * @author Doni, 02/08/2022 23:35:47
 *
 */
@RestController
@RequestMapping(path = "/api")
public class ApiController {

	@Autowired
	private ExamenesService examenesService;
	@Autowired
	private EstudiantesService estudiantesService;
	@Autowired
	private AplicacionesExamenesEstudiantesService aplicacionesExamenesEstudiantesService;
	@Autowired
	private AplicacionesExamenesRespuestasService aplicacionesExamenesRespuestasService;
	@Autowired
	private AplicacionesExamenesService aplicacionesExamenesService;
	
	/**
	 * Crear un examen. Este se compone de un conjunto de preguntas con 4 opciones, 1 opción 
	 * correcta y un puntaje por cada pregunta que en total deben sumar 100 puntos (la nota 
	 * total del examen).
	 * @param examen
	 * @return 
	 */
	@RequestMapping(path = "/examenes/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta crearExamen(@RequestBody @Valid Examen examen) {
		Respuesta respuesta = new Respuesta();
		Integer idExamen = examenesService.save(examen);
		
		return respuesta
				.setExito(idExamen != null)
				.setMensaje(idExamen.toString());
	}
	
	/**
	 * Crear un estudiante. Este se compone de la siguiente información: nombre, edad, ciudad y 
	 * zona horaria de la ciudad.
	 * @param estudiante
	 * @return
	 */
	@RequestMapping(path = "/estudiantes/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta crearEstudiante(@RequestBody @Valid Estudiante estudiante) {
		Respuesta respuesta = new Respuesta();
		Integer idEstudiante = estudiantesService.save(estudiante);
		
		return respuesta
				.setExito(idEstudiante != null)
				.setMensaje(idEstudiante.toString());
	}
	
	/**
	 * Definir fecha del examen y asignar examen a estudiantes en su zona horaria. Dada una 
	 * fecha de presentación del examen en zona horaria de Bogotá se debe recibir la fecha de 
	 * presentación para cada estudiante en su zona horaria correspondiente.
	 * @param aplicacionExamen
	 * @return
	 */
	@RequestMapping(path = "/aplicaciones/examenes/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta crearEstudiante(@RequestBody @Valid AplicacionExamen aplicacionExamen) {
		Respuesta respuesta = new Respuesta();
		Integer idAplicacionExamen = aplicacionesExamenesService.save(aplicacionExamen);
		
		return respuesta
				.setExito(idAplicacionExamen != null)
				.setMensaje(idAplicacionExamen.toString());
	}
	
	/**
	 * Recopilar las respuestas de un estudiante. Se debe poder recopilar todas las respuestas 
	 * de un estudiante en un examen que se le ha asignado.
	 * @param examen
	 * @return
	 */
	@RequestMapping(path = "/aplicaciones/examenes/recopilar/{idAplicacionExamenEstudiante}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta crearExamen(@PathVariable Integer idAplicacionExamenEstudiante, @RequestBody @Valid List<AplicacionExamenRespuesta> respuestas) {
		aplicacionesExamenesRespuestasService.saveMultiple(respuestas, idAplicacionExamenEstudiante);
		return new Respuesta().setExito(true);
	}
	
	/**
	 * Calificar los exámenes. Una vez recibida las respuestas de un estudiante se deberá 
	 * entregar la calificación de este
	 * @param idAplicacionExamenEstudiante
	 * @return
	 */
	@RequestMapping(path = "/aplicaciones/examenes/estudiantes/calificar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Respuesta crearEstudiante(@RequestBody AplicacionExamenEstudiante aplicacionExamenEstudiante) {
		Respuesta respuesta = new Respuesta();
		Integer calificacion = aplicacionesExamenesEstudiantesService.calificar(aplicacionExamenEstudiante.getIdAplicacionExamenEstudiante());
		
		return respuesta
				.setExito(calificacion != null)
				.setMensaje(calificacion.toString());
	}
}
