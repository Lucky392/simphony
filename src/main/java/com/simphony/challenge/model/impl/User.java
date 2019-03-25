package com.simphony.challenge.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.simphony.challenge.model.AbstractModel;

@Entity
@Table(name = "user")
public class User implements AbstractModel {

	@Id
	@Column(name = "email")
	@NonNull
	protected String email;
	
	@Column(name = "display_name")
	@NonNull
	private String displayName;
	
	@Column(name = "password")
	@NonNull
	protected String password;
	
	@Column(name = "admin_user")
	protected boolean admin;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Favorites> favorites;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Likes> likes;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reviews> reviews;
	
	public User() { }
	
	public User(String email) {
		this.email = email;
	}

	public User(String email, String displayName, String password, boolean admin, List<Favorites> favorites,
			List<Likes> likes, List<Reviews> reviews) {
		this.email = email;
		this.displayName = displayName;
		this.password = password;
		this.admin = admin;
		this.favorites = favorites;
		this.likes = likes;
		this.reviews = reviews;
	}
	
	public User(String email, String displayName, String password, boolean admin) {
		this.email = email;
		this.displayName = displayName;
		this.password = password;
		this.admin = admin;
	}
	
	public User(String email, String displayName, String password) {
		this.email = email;
		this.displayName = displayName;
		this.password = password;
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

	public List<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	
}
