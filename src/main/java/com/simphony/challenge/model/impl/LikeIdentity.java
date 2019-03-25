package com.simphony.challenge.model.impl;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class LikeIdentity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6485013688525799383L;

	@NotNull
    private String email;

    @NotNull
    private long hotelId;
    
    @NotNull
    private long hotelReview;
    
    public LikeIdentity() {

    }

	public LikeIdentity(String email, long hotelId, long hotelReview) {
		this.email = email;
		this.hotelId = hotelId;
		this.hotelReview = hotelReview;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getHotelReview() {
		return hotelReview;
	}

	public void setHotelReview(long hotelReview) {
		this.hotelReview = hotelReview;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	
	public long getHotelId() {
		return hotelId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikeIdentity that = (LikeIdentity) o;

        if (!email.equals(that.email)) return false;
        if (hotelReview != that.hotelReview) return false;
        return hotelId == that.hotelId;
    }
	
	
}
