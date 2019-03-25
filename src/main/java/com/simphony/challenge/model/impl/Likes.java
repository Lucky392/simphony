package com.simphony.challenge.model.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.simphony.challenge.model.AbstractModel;

@Entity
@Table(name = "likes")
public class Likes implements Serializable, AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -463474341107584560L;

	@EmbeddedId
	private LikeIdentity likesIdentity;
	
    @Column(name = "liked")
	private boolean liked;
    
	public Likes(LikeIdentity likesIdentity, boolean liked) {
		this.likesIdentity = likesIdentity;
		this.liked = liked;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("email")
    private User user;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hotelId")
    private Hotel hotel;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hotelReview")
    private Reviews review;

	public LikeIdentity getLikesIdentity() {
		return likesIdentity;
	}

	public void setLikesIdentity(LikeIdentity likesIdentity) {
		this.likesIdentity = likesIdentity;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}
    
}
