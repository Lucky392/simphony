package com.simphony.challenge.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simphony.challenge.constants.SimphonyRouter;
import com.simphony.challenge.dto.impl.LikesDTO;
import com.simphony.challenge.service.LikesService;

@RestController
@RequestMapping(value = SimphonyRouter.LIKES)
public class LikesController {

	private LikesService likesService;
	
	@Autowired
	public LikesController(LikesService likesService) {
		this.likesService = likesService;
	}
	
	@PostMapping
	public ResponseEntity<LikesDTO> likeHotelReview(@Valid @RequestBody LikesDTO likesDto) {
		likesService.createLikes(likesDto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<LikesDTO> deleteHotelReview(@Valid @RequestBody LikesDTO likesDto) {
		likesService.removeLikes(likesDto);
		return ResponseEntity.ok().build();
	}
	
}
