package com.ssafy.test.model;

public class Note {
	private String noteCode;
	private String model;
	private int price;
	private String company;

	public Note(String noteCode, String model, int price, String company) {
		this.noteCode = noteCode;
		this.model = model;
		this.price = price;
		this.company = company;
	}

	public String getNoteCode() {
		return noteCode;
	}

	public void setNoteCode(String noteCode) {
		this.noteCode = noteCode;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
