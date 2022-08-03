package com.example.fonyou.controllers;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doni, 02/08/2022 23:35:47
 *
 */
@RestController
public class ApiController {

	
	/**
	 * • Crear un examen. Este se compone de un conjunto de preguntas con 4 opciones, 1 opción
		correcta y un puntaje por cada pregunta que en total deben sumar 100 puntos (la nota
		total del examen).
		• Crear un estudiante. Este se compone de la siguiente información: nombre, edad, ciudad y
		zona horaria de la ciudad.
		• Definir fecha del examen y asignar examen a estudiantes en su zona horaria. Dada una
		fecha de presentación del examen en zona horaria de Bogotá se debe recibir la fecha de
		presentación para cada estudiante en su zona horaria correspondiente.
		• Recopilar las respuestas de un estudiante. Se debe poder recopilar todas las respuestas
		de un estudiante en un examen que se le ha asignado.
		• Calificar los exámenes. Una vez recibida las respuestas de un estudiante se deberá
		entregar la calificación de este
	 */
}
