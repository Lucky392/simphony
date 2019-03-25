package com.simphony.challenge.dto.impl;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simphony.challenge.dto.AbstractDTO;

public class UserDTO implements AbstractDTO {

	@NotNull
	private String email;
	
	private String displayName;
	
	@NotNull
	private String password;
	
	@JsonIgnore
	private boolean admin;
	
	public UserDTO() { }
	
	public UserDTO(String email, String displayName, String password) {
		this.email = email;
		this.displayName = displayName;
		this.password = password;
	}
	
	public UserDTO(String email, String displayName, String password, boolean admin) {
		this.email = email;
		this.displayName = displayName;
		this.password = password;
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
