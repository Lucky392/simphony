package com.simphony.challenge.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simphony.challenge.model.impl.Favorites;
import com.simphony.challenge.model.impl.Hotel;
import com.simphony.challenge.model.impl.FavoritesIdentity;

public interface FavoritesRepository extends JpaRepository<Favorites, FavoritesIdentity> {

	@Query("SELECT f.hotel FROM Favorites f LEFT JOIN f.hotel WHERE f.favoritesIdentity.email = ?1")
	Optional<Set<Hotel>> findFavoriteHotels(String email);
	
}
