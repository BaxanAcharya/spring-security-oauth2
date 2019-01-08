package com.biplav.oauth2.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biplav.oauth2.user.model.User;
import com.biplav.oauth2.user.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User dbUser=this.userService.findByUsername(username);
		if(dbUser==null)
		{
			throw new UsernameNotFoundException("User with username"+ username+ "not found.");
		}
		
		List<GrantedAuthority> authorities=new ArrayList<>();
		for(String authority: dbUser.getAuthorities())
		{
			authorities.add(new SimpleGrantedAuthority(authority));
		}
		
		return new org.springframework.security.core.userdetails.User
				(username, dbUser.getPassword(), authorities);

	}
	

}
