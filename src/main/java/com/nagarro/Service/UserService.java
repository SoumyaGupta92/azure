package com.nagarro.Service;

import com.nagarro.DTO.UserDTO;
import com.nagarro.entity.User;


public interface UserService{
	
	String addUser(UserDTO userDTO);

	User findUserByEmailId(String emailId, String password);

	Long countTotalUsers();

	boolean getEmailId(String emailId);
}
