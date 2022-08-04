package com.example.fonyou.dto;

import java.util.HashMap;

/**
 * @author Doni, 03/08/2022 23:08:29
 *
 */
public class Respuesta extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;
	
	public Respuesta() {
		this.put("mensaje", null);
		this.put("exito", null);
	}
	
	public Respuesta setMensaje(String mensaje) {
		this.put("mensaje", mensaje);
		return this;
	}
	
	public Respuesta setExito(Boolean exito) {
		this.put("exito", exito);
		return this;
	}
}
