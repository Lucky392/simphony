package com.simphony.challenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simphony.challenge.model.impl.User;
import com.simphony.challenge.repository.UserRepository;
import com.simphony.challenge.security.model.SimphonyUserDetails;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findById(email);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User doesn't exist!"));

		return getUserDetails(user.get());
	}
	
	private SimphonyUserDetails getUserDetails(User user) {
		return new SimphonyUserDetails(user.getEmail(), user.getDisplayName(), user.getPassword(), user.isAdmin());
	}

}