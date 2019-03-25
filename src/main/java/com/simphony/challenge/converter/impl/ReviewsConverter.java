package com.simphony.challenge.converter.impl;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.dto.impl.ReviewsDTO;
import com.simphony.challenge.model.impl.Hotel;
import com.simphony.challenge.model.impl.Reviews;
import com.simphony.challenge.model.impl.User;

public class ReviewsConverter implements Converter<Reviews, ReviewsDTO> {

	@Override
	public Reviews fromDto(ReviewsDTO d) {
		return new Reviews(d.getId(), new User(d.getUser()), new Hotel(d.getHotelId()), d.getDescription(), d.getRating());
	}

	@Override
	public ReviewsDTO toDto(Reviews m) {
		return new ReviewsDTO(m.getId(), m.getHotel().getId(), m.getUser().getEmail(), m.getDescription(), m.getRating());
	}

}
