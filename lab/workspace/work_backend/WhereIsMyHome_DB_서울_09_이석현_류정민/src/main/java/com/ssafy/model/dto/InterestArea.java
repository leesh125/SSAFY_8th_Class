package com.ssafy.model.dto;

public class InterestArea {
	private int id;
	private String userId;
	private String dongCode;
	public InterestArea(int id, String userId, String addressId) {
		this.id = id;
		this.userId = userId;
		this.dongCode = addressId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String addressId) {
		this.dongCode = addressId;
	}
	
	
}	
