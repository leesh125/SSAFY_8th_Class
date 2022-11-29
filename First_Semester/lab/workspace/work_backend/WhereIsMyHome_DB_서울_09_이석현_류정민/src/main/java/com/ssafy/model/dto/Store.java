package com.ssafy.model.dto;

public class Store {
	
	private int storeCode;
	private String storeName; // 상호명
	private String placeName; // 지점명
	private String smallIndustCode; // 소분류업종코드
	private String standardCode; // 표준산업코드
	private String standardName; // 표준산업명
	private String dongCode; // 동코드
	private String address;	// 지번주소
	private int postCode;	// 우편번호
	private String lat;		// 위도
	private String lng;		// 경도	
	
	Store(){}

	public Store(int storeCode, String storeName, String placeName, String smallIndustCode, String standardCode,
			String standardName, String dongCode, String address, int postCode, String lat, String lng) {
		super();
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.placeName = placeName;
		this.smallIndustCode = smallIndustCode;
		this.standardCode = standardCode;
		this.standardName = standardName;
		this.dongCode = dongCode;
		this.address = address;
		this.postCode = postCode;
		this.lat = lat;
		this.lng = lng;
	}

	public int getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getSmallIndustCode() {
		return smallIndustCode;
	}

	public void setSmallIndustCode(String smallIndustCode) {
		this.smallIndustCode = smallIndustCode;
	}

	public String getStandardCode() {
		return standardCode;
	}

	public void setStandardCode(String standardCode) {
		this.standardCode = standardCode;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
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
}
