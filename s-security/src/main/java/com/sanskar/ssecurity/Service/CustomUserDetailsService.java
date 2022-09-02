package com.sanskar.ssecurity.Service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sanskar.ssecurity.Entity.User;
import com.sanskar.ssecurity.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repository.findbyUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		HashSet<SimpleGrantedAuthority> authorities=new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.username, user.password, false, false, false, false, authorities);
	}

}
