package com.nagarro.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "emailId", nullable = false, unique = true)
	private String emailId;
	
	@Column(name = "password", nullable = false)
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String username, String emailId, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", password=" + password
				+ "]";
	}
	
}
