package com.nagarro.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.DTO.UserDTO;
import com.nagarro.Repository.UserRepo;
import com.nagarro.Service.UserService;
import com.nagarro.entity.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public String addUser(UserDTO userDTO) {

		User user = new User();

		user.setUserId(userDTO.getUserId());
		user.setUsername(userDTO.getUsername());
		user.setEmailId(userDTO.getEmailId());
		user.setPassword(userDTO.getPassword());

		userRepo.save(user);

		return user.getUsername();
	}

	@Override
	public User findUserByEmailId(String emailId, String password) {
		User user = userRepo.findOneByEmailIdAndPassword(emailId,password);
		return user;
	}

	@Override
	public Long countTotalUsers() {
		return userRepo.count();
	}

	@Override
	public boolean getEmailId(String emailId) {
		User user = userRepo.findByEmailId(emailId);
		if(user == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
