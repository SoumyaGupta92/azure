package com.nagarro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.DTO.UserDTO;
import com.nagarro.Service.UserService;
import com.nagarro.entity.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// Save User Details --> For User Registration
	@PostMapping(path = "/save")
	public boolean registerUser(@RequestBody UserDTO userDTO) {
		String username = userService.addUser(userDTO);
		if(username != null) {
			System.out.println(username + "true");
			return true;
		}
		else {
			System.out.println(username + "false");
			return false;
		}
	}

	// Get User by EmailId --> For Login
	@GetMapping("/login/{emailId}/{password}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
		User user = userService.findUserByEmailId(emailId, password);
		return ResponseEntity.ok(user);
	}
	
	//Get total number of users
	@GetMapping("/totalUser")
	public Long totalNumberOfUsers() {
		System.out.println(userService.countTotalUsers());
		return userService.countTotalUsers();
	}
	
	//check user with same emailId present or not
	@GetMapping("/emailpresent/{emailId}")
	public boolean getEmailId(@PathVariable("emailId") String emailId) {
		return userService.getEmailId(emailId);
	}
	
}
