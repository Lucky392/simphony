package com.simphony.challenge.model.impl;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class FavoritesIdentity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5783975683147696586L;

	@NotNull
    private String email;

    @NotNull
    private long hotelId;
    
    public FavoritesIdentity() {

    }

    public FavoritesIdentity(String email, Long hotelId) {
        this.email = email;
        this.hotelId = hotelId;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoritesIdentity that = (FavoritesIdentity) o;

        if (!email.equals(that.email)) return false;
        return hotelId == that.hotelId;
    }
	
	
}
