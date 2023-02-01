package com.martinez.app.escuelaspring.dtos;

import java.util.Map;

public class ResponsesDTO {
	
	private Map<String, String> response;

	public ResponsesDTO() {
		super();
	}

	public Map<String, String> getResponse() {
		return response;
	}

	public void setResponse(Map<String, String> response) {
		this.response = response;
	}

	
}
