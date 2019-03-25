package com.simphony.challenge.api;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simphony.challenge.constants.RestVariables;
import com.simphony.challenge.constants.SimphonyRouter;
import com.simphony.challenge.dto.impl.HotelDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.service.HotelService;

@RestController
@RequestMapping(value = SimphonyRouter.HOTEL)
public class HotelController {
	
	private HotelService hotelService;
	
	@Autowired
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping
	public ResponseEntity<Set<HotelDTO>> getHotels(@RequestParam(name = RestVariables.NAME, required = false) String name, @RequestParam(name = RestVariables.ADDRESS, required = false) String address, Pageable page) {
		if (name == null && address == null) {			
			return ResponseEntity.ok(hotelService.getHotels());
		} else {
			return ResponseEntity.ok(hotelService.getHotelsByCriteria(new HotelDTO(name, address)));
		}
	}
	
	@GetMapping(value = SimphonyRouter.FIND_BY_ID)
	public ResponseEntity<HotelDTO> getHotel(@PathVariable(name = RestVariables.ID) long id) {
		try {
			return ResponseEntity.ok(hotelService.getHotel(id));
		} catch (SimphonyException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<HotelDTO> createHotel(@Valid @RequestBody HotelDTO hotelDto) {
		hotelService.createHotel(hotelDto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<HotelDTO> updateHotel(@Valid @RequestBody HotelDTO hotelDto) {
		try {
			hotelService.updateHotel(hotelDto);
			return ResponseEntity.ok().build();
		} catch (SimphonyException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Used to update data about image (example) without other fields, other fields could be updated as well
	@PatchMapping
	public ResponseEntity<HotelDTO> updateHotelPartial(@RequestBody HotelDTO hotelDto) {
		try {
			hotelService.updateHotel(hotelDto);
			return ResponseEntity.ok().build();
		} catch (SimphonyException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
