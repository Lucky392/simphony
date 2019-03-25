package com.simphony.challenge.converter.impl;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.dto.impl.UserDTO;
import com.simphony.challenge.model.impl.User;

public class UserConverter implements Converter<User, UserDTO>{

	@Override
	public User fromDto(UserDTO d) {
		return new User(d.getEmail(), d.getDisplayName(), d.getPassword());
	}

	@Override
	public UserDTO toDto(User m) {
		return new UserDTO(m.getEmail(), m.getDisplayName(), m.getPassword());
	}

}
