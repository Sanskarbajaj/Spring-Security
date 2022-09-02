package com.sanskar.ssecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sanskar.ssecurity.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query(value="select * from user where username = (:username)",nativeQuery = true)
	public User findbyUsername(@Param("username") String username);

}
