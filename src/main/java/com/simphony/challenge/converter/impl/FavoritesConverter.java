package com.simphony.challenge.converter.impl;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.dto.impl.FavoritesDTO;
import com.simphony.challenge.model.impl.Favorites;
import com.simphony.challenge.model.impl.FavoritesIdentity;

public class FavoritesConverter implements Converter<Favorites, FavoritesDTO> {

	@Override
	public Favorites fromDto(FavoritesDTO d) {
		return new Favorites(new FavoritesIdentity(d.getEmail(), d.getHotel()));
	}

	@Override
	public FavoritesDTO toDto(Favorites m) {
		return new FavoritesDTO(m.getFavoritesIdentity().getHotelId());
	}

}
