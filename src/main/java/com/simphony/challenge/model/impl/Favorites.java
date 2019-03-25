package com.simphony.challenge.model.impl;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.simphony.challenge.model.AbstractModel;

@Entity
@Table(name = "favorites")
public class Favorites implements Serializable, AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -969478024792178328L;
	
	@EmbeddedId
	private FavoritesIdentity favoritesIdentity;

	public Favorites(FavoritesIdentity favoritesIdentity) {
		this.favoritesIdentity = favoritesIdentity;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("email")
    private User user;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hotelId")
    private Hotel hotel;

	public FavoritesIdentity getFavoritesIdentity() {
		return favoritesIdentity;
	}

	public void setFavoritesIdentity(FavoritesIdentity favoritesIdentity) {
		this.favoritesIdentity = favoritesIdentity;
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
	
}
