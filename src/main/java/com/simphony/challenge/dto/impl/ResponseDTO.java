package com.simphony.challenge.dto.impl;

import com.simphony.challenge.dto.AbstractDTO;

public class ResponseDTO implements AbstractDTO {

	private String message;
	
	public ResponseDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
