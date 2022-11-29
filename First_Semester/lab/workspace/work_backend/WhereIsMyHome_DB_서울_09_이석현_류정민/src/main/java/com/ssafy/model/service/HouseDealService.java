package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.BaseAddressDAO;
import com.ssafy.model.dao.HouseDealDAO;
import com.ssafy.model.dto.BaseAddress;
import com.ssafy.model.dto.HouseDeal;

public class HouseDealService {

	private HouseDealDAO houseDealDao = new HouseDealDAO();
	private BaseAddressDAO baseAddressDao = new BaseAddressDAO();

	public List<HouseDeal> getHouseDeals() throws SQLException {
		return houseDealDao.getHouseDeals();
	}

	public List<HouseDeal> getHouseDealsByDong(String dongCode) throws SQLException {
		return houseDealDao.getHouseDealsByDong(dongCode);
	}

	public List<HouseDeal> getHouseDealsByApt(String aptCode) throws SQLException {
		return houseDealDao.getHouseDealsByApt(aptCode);
	}
	
	public BaseAddress getLatLng(String dongCode) throws SQLException {
		return baseAddressDao.getBaseAddress(dongCode);
	}
}
