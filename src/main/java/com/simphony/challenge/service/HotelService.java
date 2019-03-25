package com.simphony.challenge.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.simphony.challenge.constants.SimphonyConstants;
import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.converter.impl.HotelConverter;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.factory.SimphonyFactory;
import com.simphony.challenge.model.impl.Hotel;
import com.simphony.challenge.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	private Converter<Hotel, HotelDTO> converter;
	
	public HotelService() {
		try {
			converter = SimphonyFactory.getConverter(HotelConverter.class);
		} catch (SimphonyException e) {
			// Should never happen
			e.printStackTrace();
		}
	}
	
	public Set<HotelDTO> getHotels() {
		final Sort sort = new Sort(Direction.ASC, SimphonyConstants.NAME);
		final List<Hotel> hotels = hotelRepository.findAll(sort);
		return hotels.stream().map(hotel -> converter.toDto(hotel)).collect(Collectors.toSet());
	}
	
	public HotelDTO getHotel(long id) throws SimphonyException {
		final Optional<Hotel> hotel = hotelRepository.findById(id);
		hotel.orElseThrow(() -> new SimphonyException("No hotel with selected id!"));
		return converter.toDto(hotel.get());
	}
	
	public void createHotel(HotelDTO hotel) { 
		hotelRepository.saveAndFlush(converter.fromDto(hotel));
	}
	
	public void updateHotel(HotelDTO hotelDto) throws SimphonyException {
		try {
			final Hotel hotel = hotelRepository.getOne(hotelDto.getId());
			updateHotel(hotel, hotelDto);
			hotelRepository.saveAndFlush(hotel);
		} catch (EntityNotFoundException e) {
			throw new SimphonyException(e.getMessage());
		}
	}
	
	private void updateHotel(Hotel hotel, HotelDTO hotelDto) {
		if (hotelDto.getAddress() != null) {
			hotel.setAddress(hotelDto.getAddress());
		}
		if (hotelDto.getImage() != null) {
			hotel.setImage(hotelDto.getImage());
		}
		if (hotelDto.getDescription() != null) {
			hotel.setDescription(hotelDto.getDescription());
		}
		if (hotelDto.getLat() != null) {
			hotel.setLat(hotelDto.getLat());
		}
		if (hotelDto.getLng() != null) {
			hotel.setLng(hotelDto.getLng());
		}
		if (hotelDto.getName() != null) {
			hotel.setName(hotelDto.getName());
		}
	}
	
	public Set<HotelDTO> getHotelsByCriteria(HotelDTO hotelDto) {
		validateHotelNameAndAddress(hotelDto);
		final Optional<List<Hotel>> hotel = hotelRepository.findByNameAddress(hotelDto.getName(), hotelDto.getAddress());
		return hotel.orElseGet(() -> Collections.emptyList()).stream()
					.map(h -> converter.toDto(h))
					.collect(Collectors.toSet());
	}

	private void validateHotelNameAndAddress(HotelDTO hotel) {
		if (hotel.getName() == null) {
			hotel.setName(SimphonyConstants.EMPTY);
		}
		if (hotel.getAddress() == null) {
			hotel.setAddress(SimphonyConstants.EMPTY);
		}
	}
	
}
