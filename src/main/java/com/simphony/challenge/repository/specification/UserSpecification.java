package com.simphony.challenge.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.simphony.challenge.model.impl.User;


public class UserSpecification implements Specification<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4650452396587908644L;
	
	private long hotelId;
	private boolean liked;
	
	public UserSpecification(long hotelId, boolean liked) {
		this.hotelId = hotelId;
		this.liked = liked;
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO: implement predicate using hotelId and liked
		return null;
	}


}
