package com.example.fonyou.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.fonyou.dto.Respuesta;

/**
 * @author Doni, 05/08/2022 02:05:23
 *
 */
@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Respuesta errorGenerico(Exception e) {
		return new Respuesta()
				.setExito(false)
				.setMensaje(e.getMessage());
	}
}
