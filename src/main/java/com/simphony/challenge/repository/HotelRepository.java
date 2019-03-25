package com.simphony.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simphony.challenge.model.impl.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	//Should be changed to LIKE
	@Query("SELECT h FROM Hotel h WHERE h.name = ?1 OR h.address = ?2")
	Optional<List<Hotel>> findByNameAddress(String name, String address);
	
}
