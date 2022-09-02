package com.sanskar.ssecurity.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sanskar.ssecurity.Entity.CustomUserDetails;
import com.sanskar.ssecurity.Service.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		// TODO Auto-generated method stub
		
		//http basic in memory authentication every request you need to send user and password.
		
	//	auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("userpassword")).roles("user");
	//	auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("adminpassword")).roles("admin");
	
		
		//basic and form based authenticaltion with userdetails (checking weather user present in our database or not)
		
		auth.userDetailsService(customUserDetailsService);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/public")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();  //this form login can be changed by httpBasic (popup for username and password and no logout functionality)
	}
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
