package com.simphony.challenge.dto.impl;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.simphony.challenge.dto.AbstractDTO;

public class ReviewsDTO implements AbstractDTO {

	private long id;
	
	@NotNull
	private long hotelId;
	
	@NotNull
	private String user;
	
	@NotNull
	private String description;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 5)
	private int rating;
	
	

	public ReviewsDTO(long id, long hotelId, String user, String description, int rating) {
		this.id = id;
		this.hotelId = hotelId;
		this.user = user;
		this.description = description;
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
