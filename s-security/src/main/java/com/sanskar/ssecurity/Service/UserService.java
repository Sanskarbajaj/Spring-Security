package com.sanskar.ssecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanskar.ssecurity.Entity.User;
import com.sanskar.ssecurity.Repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> getAllUser() {
		return repository.findAll();
	}
	
	public User getbyUsername(String username) {
		return repository.findbyUsername(username);
	}

}
