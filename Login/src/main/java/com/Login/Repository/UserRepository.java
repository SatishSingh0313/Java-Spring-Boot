package com.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Login.Module.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user where username=?1 or email=?2",nativeQuery=true)
	User findByUserNameOrEmail(String username, String email);
}
