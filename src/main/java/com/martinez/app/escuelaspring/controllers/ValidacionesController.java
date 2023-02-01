package com.martinez.app.escuelaspring.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.app.escuelaspring.dtos.ResponsesDTO;
import com.martinez.app.escuelaspring.dtos.UsuarioDTO;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/escuela/validaciones")
@CrossOrigin(origins = "*")
public class ValidacionesController {
	
	Logger LOG = Logger.getLogger("com.martinez.app.escuelaspring.controllers.ValidacionesController");
	@PostMapping
	public ResponseEntity<ResponsesDTO> validarCorreo(@Valid @RequestBody UsuarioDTO usuario, BindingResult bindingResults){
		ResponsesDTO respuesta = new ResponsesDTO();
		Map<String, String> res = new HashMap<>();
		
		
		if (bindingResults.hasErrors()) {
			for	(FieldError error: bindingResults.getFieldErrors()) {
				res.put(error.getField(), error.getDefaultMessage());
			}
			respuesta.setResponse(res);
		} else {
			res.put("message", "correo válido");		
			respuesta.setResponse(res);
		}
		
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
		
		
	}
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
//		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//	}
}
