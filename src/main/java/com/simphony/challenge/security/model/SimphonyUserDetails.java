package com.simphony.challenge.security.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.simphony.challenge.model.impl.User;
import com.simphony.challenge.security.constants.Role;

public class SimphonyUserDetails extends User implements UserDetails {
	
	public SimphonyUserDetails() { }
	
	public SimphonyUserDetails(String email, String displayName, String password, boolean admin) {
		super(email, displayName, password, admin);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530712052278906529L;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return admin ? Arrays.asList(new SimpleGrantedAuthority(Role.ROLE_ADMIN)) : Arrays.asList(new SimpleGrantedAuthority(Role.ROLE_USER));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
