package com.biplav.oauth2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.biplav.oauth2.user.model.User;
import com.biplav.oauth2.user.service.UserService;

@SpringBootApplication
public class SpringSecurityOauth2Application implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(this.userService.findByUsername("baxan12")==null)
		{
			User user=new User();
			user.setName("Biplav");
			user.setUsername("baxan12");
			user.setPassword(this.passwordEncoder.encode("baxanacharya@gmail.com"));
			user.setAuthorities(Arrays.asList("GOD"));
			this.userService.save(user);
		}
		
	}

}

