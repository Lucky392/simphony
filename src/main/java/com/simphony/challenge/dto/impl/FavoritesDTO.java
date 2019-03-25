package com.simphony.challenge.dto.impl;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simphony.challenge.dto.AbstractDTO;

public class FavoritesDTO implements AbstractDTO {

	@JsonIgnore
	private String email;
	
	public FavoritesDTO(Long hotel) {
		super();
		this.hotel = hotel;
	}

	@NotNull
	private Long hotel;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getHotel() {
		return hotel;
	}

	public void setHotel(Long hotel) {
		this.hotel = hotel;
	}
	
}
