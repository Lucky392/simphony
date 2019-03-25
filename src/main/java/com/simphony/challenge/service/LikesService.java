package com.simphony.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.converter.impl.LikesConverter;
import com.simphony.challenge.dto.impl.LikesDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.factory.SimphonyFactory;
import com.simphony.challenge.model.impl.Likes;
import com.simphony.challenge.repository.LikesRepository;

@Service
public class LikesService {

	@Autowired
	private LikesRepository likesRepository;
	
	private Converter<Likes, LikesDTO> converter;
	
	public LikesService() {
		try {
			converter = SimphonyFactory.getConverter(LikesConverter.class);
		} catch (SimphonyException e) {
			// Should never happen!
			e.printStackTrace();
		}
	}
	
	public void createLikes(LikesDTO like) {
		likesRepository.save(converter.fromDto(like));
	}
	
	public void removeLikes(LikesDTO like) {
		likesRepository.delete(converter.fromDto(like));
	}
	
}
