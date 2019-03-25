package com.simphony.challenge.api;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simphony.challenge.constants.SimphonyRouter;
import com.simphony.challenge.dto.impl.FavoritesDTO;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.dto.impl.ResponseDTO;
import com.simphony.challenge.service.FavoritesService;

@RestController
@RequestMapping(value = SimphonyRouter.FAVORITES)
public class FavoritesController {
	
	private FavoritesService favoritesService;
	
	@Autowired
	public FavoritesController(FavoritesService favoritesService) {
		this.favoritesService = favoritesService;
	}

	@GetMapping
	public ResponseEntity<Set<HotelDTO>> getMyFavorites(Authentication auth, Pageable page) {
		return ResponseEntity.ok(favoritesService.getFavorites(auth.getName()));
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addToFavorites(@Valid @RequestBody FavoritesDTO favorite, Authentication auth) {
		favorite.setEmail(auth.getName());
		favoritesService.createFavorite(favorite);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseDTO> deleteFromFavorites(@Valid @RequestBody FavoritesDTO favorite, Authentication auth) {
		favorite.setEmail(auth.getName());
		favoritesService.removeFavorite(favorite);
		return ResponseEntity.ok().build();
	}
	
}
