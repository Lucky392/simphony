package com.simphony.challenge.converter.impl;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.model.impl.Hotel;

public class HotelConverter implements Converter<Hotel, HotelDTO> {

	@Override
	public Hotel fromDto(HotelDTO d) {
		return new Hotel(d.getId(), d.getName(), d.getAddress(), d.getImage(), d.getDescription(), d.getLng(), d.getLat());
	}

	@Override
	public HotelDTO toDto(Hotel m) {
		return new HotelDTO(m.getId(), m.getName(), m.getAddress(), m.getImage(), m.getDescription(), m.getLng(), m.getLat(), m.getOveralRating());
	}

}
