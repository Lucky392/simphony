package com.simphony.challenge.constants;

public interface SimphonyRouter {

	String USER = "/user";
	String HOTEL = "/hotel";
	String FAVORITES = "/favorites";
	String LIKES = "/likes";
	String LIKED = "/liked/{hotel}";
	String DISLIKED = "/disliked/{hotel}";
	String REVIEWS = "/reviews";

	String FIND_BY_ID = "/{id}";
	
}
