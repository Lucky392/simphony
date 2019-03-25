package com.simphony.challenge.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.simphony.challenge.model.AbstractModel;

@Entity
@Table(name = "hotel")
public class Hotel implements AbstractModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	@NonNull
	private String name;
	
	@Column(name = "address")
	@NonNull
	private String address;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "description")
	@NonNull
	private String description;
	
	@Column(name = "lng")
	private Float lng;
	
	@Column(name = "lat")
	private Float lat;
	
	@Column(name = "overal_rating")
	@NonNull
	private float overalRating;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Favorites> favorites;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Likes> likes;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Reviews> reviews;
	
	public Hotel() { }
	
	public Hotel(Long id, String name, String address, String image, String description, Float lng, Float lat,
			float overalRating) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.image = image;
		this.description = description;
		this.lng = lng;
		this.lat = lat;
		this.overalRating = overalRating;
	}
	
	public Hotel(Long id, String name, String address, String image, String description, Float lng, Float lat) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.image = image;
		this.description = description;
		this.lng = lng;
		this.lat = lat;
	}
	
	public Hotel(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public float getOveralRating() {
		return overalRating;
	}

	public void setOveralRating(float overalRating) {
		this.overalRating = overalRating;
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
