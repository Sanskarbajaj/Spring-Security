package com.sanskar.ssecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sanskar.ssecurity.Entity.User;
import com.sanskar.ssecurity.Repository.UserRepository;

@SpringBootApplication
public class SSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SSecurityApplication.class, args);
	}

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user= new User();
		user.setId(2);
		user.setIsEnabled(true);
		user.setPassword(encoder.encode("userpassword"));
		user.setRole("ROLE_user");
		user.setUsername("user");
		repository.save(user);
		
		User user1= new User();
		user1.setId(1);
		user1.setIsEnabled(true);
		user1.setPassword(encoder.encode("adminpassword"));
		user1.setRole("ROLE_admin");
		user1.setUsername("admin");
		repository.save(user1);
	}

}
