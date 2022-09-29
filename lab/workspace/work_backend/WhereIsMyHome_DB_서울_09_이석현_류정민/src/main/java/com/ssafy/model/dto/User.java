package com.ssafy.model.dto;

public class User {
	private String userId;
	private String password;
	private String username;
	private String address;
	private String phoneNumber;
	
	public User(String userId, String password, String username, String address, String phoneNumber) {
		this.userId = userId;
		this.password = password;
		this.username = username;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
