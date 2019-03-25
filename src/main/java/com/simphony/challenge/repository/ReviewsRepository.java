package com.simphony.challenge.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simphony.challenge.model.impl.Hotel;
import com.simphony.challenge.model.impl.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

	@Query("SELECT r.hotel FROM Reviews r LEFT JOIN r.hotel WHERE r.hotel.id = ?1")
	public Optional<Set<Hotel>> getHotelReviews(long hotelId);
	
}
