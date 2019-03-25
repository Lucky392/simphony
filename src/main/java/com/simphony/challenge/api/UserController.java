package com.simphony.challenge.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simphony.challenge.constants.SimphonyRouter;
import com.simphony.challenge.dto.impl.UserDTO;
import com.simphony.challenge.service.UserService;


@RestController
@RequestMapping(value=SimphonyRouter.USER)
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<Object> signUp(@Valid @RequestBody UserDTO user) {
		userService.createUser(user);
		return ResponseEntity.ok().build();
	}
	
}
