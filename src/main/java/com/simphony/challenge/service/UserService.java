package com.simphony.challenge.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simphony.challenge.converter.Converter;
import com.simphony.challenge.converter.impl.UserConverter;
import com.simphony.challenge.dto.impl.UserDTO;
import com.simphony.challenge.exception.SimphonyException;
import com.simphony.challenge.factory.SimphonyFactory;
import com.simphony.challenge.model.impl.User;
import com.simphony.challenge.repository.UserRepository;
import com.simphony.challenge.repository.specification.UserSpecification;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private Converter<User, UserDTO> converter;
	
	public UserService() {
		try {
			converter = SimphonyFactory.getConverter(UserConverter.class);
		} catch (SimphonyException e) {
			// Should never happen!
			e.printStackTrace();
		}
	}
	
	public void createUser(UserDTO userDto) {
		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userRepository.saveAndFlush(converter.fromDto(userDto));
	}
	
	public Set<UserDTO> getUsers(long hotel, boolean liked) {
		List<User> users = userRepository.findAll(new UserSpecification(hotel, liked));
		return users == null ? Collections.emptySet() : users.stream().map(user -> converter.toDto(user)).collect(Collectors.toSet());
	}
	
}
