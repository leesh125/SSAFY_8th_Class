package com.ssafy.model.dto;

public class Environ {
	
	private int no;
	private String companyName;
	private int businessCode;
	private String businessName;
	private String checkDate;
	private int checkInst;
	private String checkType;
	private String disposal;
	private String checkList;
	private String address;
	private String lat;
	private String lng;
	
	Environ(){}

	public Environ(int no, String companyName, int businessCode, String businessName, String checkDate,
			int checkInst, String checkType, String disposal, String checkList, String address, String lat, String lng) {
		super();
		this.no = no;
		this.companyName = companyName;
		this.businessCode = businessCode;
		this.businessName = businessName;
		this.checkDate = checkDate;
		this.checkInst = checkInst;
		this.checkType = checkType;
		this.disposal = disposal;
		this.checkList = checkList;
		this.address = address;
		this.lat = lat;
		this.lng = lng;	
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public int getCheckInst() {
		return checkInst;
	}

	public void setCheckInst(int checkInst) {
		this.checkInst = checkInst;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getDisposal() {
		return disposal;
	}

	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}

	public String getCheckList() {
		return checkList;
	}

	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
