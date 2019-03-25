package com.simphony.challenge.service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.converter.impl.HotelConverter;
import com.simphony.challenge.converter.impl.ReviewsConverter;
import com.simphony.challenge.converter.impl.UserConverter;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.dto.impl.ReviewsDTO;
import com.simphony.challenge.dto.impl.UserDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.factory.SimphonyFactory;
import com.simphony.challenge.model.impl.Hotel;
import com.simphony.challenge.model.impl.Reviews;
import com.simphony.challenge.model.impl.User;
import com.simphony.challenge.repository.ReviewsRepository;
import com.simphony.challenge.repository.specification.UserSpecification;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsRepository reviewsRepository;
	
	private Converter<Reviews, ReviewsDTO> converter;
	private Converter<Hotel, HotelDTO> hotelConverter;
	private Converter<User, UserDTO> userConverter;
	
	public ReviewsService() {
		try {
			converter = SimphonyFactory.getConverter(ReviewsConverter.class);
			hotelConverter = SimphonyFactory.getConverter(HotelConverter.class);
			userConverter = SimphonyFactory.getConverter(UserConverter.class);
		} catch (SimphonyException e) {
			// Should never happen!
			e.printStackTrace();
		}
	}
	
	public void createReview(ReviewsDTO review) {
		reviewsRepository.saveAndFlush(converter.fromDto(review));
	}
	
	public Set<HotelDTO> getHotelReviews(Long hotelId) {
		return reviewsRepository.getHotelReviews(hotelId)
				.orElseGet(() -> Collections.emptySet()).stream()
					.map(h -> hotelConverter.toDto(h))
					.collect(Collectors.toSet());
	}
	
}
