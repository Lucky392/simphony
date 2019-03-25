package com.simphony.challenge.model.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.simphony.challenge.model.AbstractModel;

@Entity
@Table(name = "reviews")
public class Reviews implements Serializable, AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5930645735428010120L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn
	private User user;
	
	@ManyToOne
    @JoinColumn
	private Hotel hotel;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "rating")
	private int rating;
	
	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Likes> likes;
	
	public Reviews(Long id, User user, Hotel hotel, String description, int rating) {
		this.id = id;
		this.user = user;
		this.hotel = hotel;
		this.description = description;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
