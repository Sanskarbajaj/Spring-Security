package com.sanskar.ssecurity.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	public Integer id;
	public String username;
	public String password;
	public String role;
	public Boolean isEnabled;

}
