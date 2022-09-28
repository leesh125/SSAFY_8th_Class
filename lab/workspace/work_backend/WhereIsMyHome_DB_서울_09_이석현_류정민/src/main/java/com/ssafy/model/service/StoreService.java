package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.StoreDAO;
import com.ssafy.model.dto.Store;

public class StoreService {

	StoreDAO storeDao = new StoreDAO();
	
	// 소분류코드로 상권정보 조회
	public List<Store> getStoresByIndust(String industCode) throws SQLException {
		return storeDao.getStoresByIndust(industCode);
	}
}
