package com.simphony.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simphony.challenge.model.impl.LikeIdentity;
import com.simphony.challenge.model.impl.Likes;

public interface LikesRepository extends JpaRepository<Likes, LikeIdentity> {

}
