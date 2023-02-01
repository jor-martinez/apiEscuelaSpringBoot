package com.martinez.app.escuelaspring.dtos;

import jakarta.validation.constraints.Email;

public class UsuarioDTO {
	
	@Email(message = "correo no válido")
	private String correo;

	public UsuarioDTO() {
		super();
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
}
