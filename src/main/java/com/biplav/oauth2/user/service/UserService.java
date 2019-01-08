package com.biplav.oauth2.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biplav.oauth2.user.model.User;
import com.biplav.oauth2.user.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
		
	}
	public User save(User user) {
		return this.userRepository.save(user);
	}

}
