package com.simphony.challenge.api;

import java.util.Set;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simphony.challenge.constants.SimphonyConstants;
import com.simphony.challenge.constants.SimphonyRouter;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.dto.impl.ReviewsDTO;
import com.simphony.challenge.dto.impl.UserDTO;
import com.simphony.challenge.service.ReviewsService;
import com.simphony.challenge.service.UserService;

@RestController
@RequestMapping(value = SimphonyRouter.REVIEWS)
public class ReviewsController {

	private ReviewsService reviewsService;
	private UserService userService;
	
	@Autowired
	public ReviewsController(ReviewsService reviewsService, UserService userService) {
		this.reviewsService = reviewsService;
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<ReviewsDTO> createReview(@Valid @RequestBody ReviewsDTO review) {
		reviewsService.createReview(review);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = SimphonyRouter.FIND_BY_ID)
	public ResponseEntity<Set<HotelDTO>> getReviews(@PathVariable long hotelId, Pageable page) {
		return ResponseEntity.ok(reviewsService.getHotelReviews(hotelId));
	}
	
	@GetMapping(value = SimphonyRouter.LIKED)
	public ResponseEntity<Set<UserDTO>> getUsersLiked(@PathParam(value = SimphonyConstants.HOTEL) long hotel, Pageable page) {
		return ResponseEntity.ok(userService.getUsers(hotel, true));
	}
	
	@GetMapping(value = SimphonyRouter.DISLIKED)
	public ResponseEntity<Set<UserDTO>> getUsersDisliked(@PathParam(value = SimphonyConstants.HOTEL) long hotel, Pageable page) {
		return ResponseEntity.ok(userService.getUsers(hotel, false));
	}
	
}
