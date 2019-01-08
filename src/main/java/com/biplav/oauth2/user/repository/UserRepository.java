package com.biplav.oauth2.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.biplav.oauth2.user.model.User;

public interface UserRepository extends MongoRepository<com.biplav.oauth2.user.model.User, String>{

	User findByUsername(String username);

}
