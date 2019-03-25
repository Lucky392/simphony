package com.simphony.challenge.service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.converter.impl.FavoritesConverter;
import com.simphony.challenge.converter.impl.HotelConverter;
import com.simphony.challenge.dto.impl.FavoritesDTO;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.factory.SimphonyFactory;
import com.simphony.challenge.model.impl.Favorites;
import com.simphony.challenge.model.impl.Hotel;
import com.simphony.challenge.repository.FavoritesRepository;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesRepository favoritesRepository;
	
	private Converter<Favorites, FavoritesDTO> converter;
	private Converter<Hotel, HotelDTO> hotelConverter;
	
	public FavoritesService() {
		try {
			converter = SimphonyFactory.getConverter(FavoritesConverter.class);
			hotelConverter = SimphonyFactory.getConverter(HotelConverter.class);
		} catch (SimphonyException e) {
			// Should never happen
			e.printStackTrace();
		}
	}
	
	public void createFavorite(FavoritesDTO favoriteDto) {
		final Favorites favorite = converter.fromDto(favoriteDto);
		favoritesRepository.saveAndFlush(favorite);
	}
	
	public void removeFavorite(FavoritesDTO favoriteDto) {
		favoritesRepository.delete(converter.fromDto(favoriteDto));
	}
	
	public Set<HotelDTO> getFavorites(String email) {
		return favoritesRepository.findFavoriteHotels(email)
				.orElseGet(() -> Collections.emptySet()).stream()
					.map(hotel -> hotelConverter.toDto(hotel))
					.collect(Collectors.toSet());
	}
	
}
