package com.ssafy.model.dto;

public class BaseIndustry {
	
	private String code;
	private String name;
	
	BaseIndustry(){}

	public BaseIndustry(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BaseIndustry [code=" + code + ", name=" + name + "]";
	}
}
