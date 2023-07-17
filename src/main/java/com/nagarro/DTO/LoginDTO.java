package com.nagarro.DTO;

public class LoginDTO {
	
	private String emailId;
	private String password;
	
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginDTO(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
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
	
	

}
