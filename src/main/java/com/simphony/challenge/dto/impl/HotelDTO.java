package com.simphony.challenge.dto.impl;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simphony.challenge.dto.AbstractDTO;

public class HotelDTO implements AbstractDTO {

	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	private String image;
	
	private String description;
	
	private Float lng;
	
	private Float lat;
	
	@JsonIgnore
	private float overalRating;
	
	public HotelDTO() { }
	
	public HotelDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public HotelDTO(String name, String address, String image, String description, Float lng,
			Float lat, float overalRating) {
		this.name = name;
		this.address = address;
		this.image = image;
		this.description = description;
		this.lng = lng;
		this.lat = lat;
		this.overalRating = overalRating;
	}
	
	public HotelDTO(Long id, String name, String address, String image, String description, Float lng,
			Float lat, float overalRating) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.image = image;
		this.description = description;
		this.lng = lng;
		this.lat = lat;
		this.overalRating = overalRating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public float getOveralRating() {
		return overalRating;
	}

	public void setOveralRating(float overalRating) {
		this.overalRating = overalRating;
	}
	
}
