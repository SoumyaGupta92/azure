package com.nagarro.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findOneByEmailIdAndPassword(String emailId, String password);
	
	User findByEmailId(String emailId);
}
