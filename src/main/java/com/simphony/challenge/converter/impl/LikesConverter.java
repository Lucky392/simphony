package com.simphony.challenge.converter.impl;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.dto.impl.LikesDTO;
import com.simphony.challenge.model.impl.LikeIdentity;
import com.simphony.challenge.model.impl.Likes;

public class LikesConverter implements Converter<Likes, LikesDTO> {

	@Override
	public Likes fromDto(LikesDTO d) {
		return new Likes(new LikeIdentity(d.getEmail(), d.getHotel(), d.getReview()), d.isLiked());
	}

	@Override
	public LikesDTO toDto(Likes m) {
		return new LikesDTO(m.getLikesIdentity().getEmail(), m.getLikesIdentity().getHotelId(), m.getLikesIdentity().getHotelReview(), m.isLiked());
	}

}
