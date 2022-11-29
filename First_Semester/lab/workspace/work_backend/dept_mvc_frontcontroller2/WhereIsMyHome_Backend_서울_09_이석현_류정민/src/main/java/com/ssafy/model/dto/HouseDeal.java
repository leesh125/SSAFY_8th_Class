package com.ssafy.model.dto;

public class HouseDeal {
	private int no;
	private String aptName;
	private String dealAmount;
	private String area;
	private int dealYear;
	private int dealMonth;
	private int dealday;
	private String lat;
	private String lng;

	public HouseDeal() {
		super();
	}

	public HouseDeal(int no, String aptName, String dealAmount, String area, int dealYear, int dealMonth, int dealday, String lat, String lng) {
		super();
		this.no = no;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealday = dealday;
		this.lat = lat;
		this.lng = lng;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealday() {
		return dealday;
	}

	public void setDealday(int dealday) {
		this.dealday = dealday;
	}
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "HouseDeal [no=" + no + ", aptName=" + aptName + ", dealAmount=" + dealAmount + ", area=" + area
				+ ", dealYear=" + dealYear + ", dealMonth=" + dealMonth + ", dealday=" + dealday + ", lat=" + lat
				+ ", lng=" + lng + "]";
	}
}