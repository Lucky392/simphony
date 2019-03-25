package com.simphony.challenge.dto.impl;

import javax.validation.constraints.NotNull;

import com.simphony.challenge.dto.AbstractDTO;

public class LikesDTO implements AbstractDTO {

	@NotNull
	private String email;
	
	@NotNull
	private Long hotel;
	
	@NotNull
	private Long review;
	
	@NotNull
	private boolean liked;
	
	public LikesDTO(String email, long hotel, Long review, boolean liked) {
		super();
		this.email = email;
		this.hotel = hotel;
		this.review = review;
		this.liked = liked;
	}

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

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public Long getReview() {
		return review;
	}

	public void setReview(Long review) {
		this.review = review;
	}
	
}
