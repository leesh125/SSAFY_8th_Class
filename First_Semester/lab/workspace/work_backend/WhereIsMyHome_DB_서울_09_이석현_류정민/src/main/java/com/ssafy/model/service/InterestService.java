package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.InterestDAO;
import com.ssafy.model.dto.InterestArea;

public class InterestService {

	private InterestDAO interestDAO = new InterestDAO();
	
	public boolean register(String userId, String dongCode) throws SQLException {
		return interestDAO.register(userId, dongCode) > 0;
	}

	public List<String> getInterests(String userId) throws SQLException {
		return interestDAO.getInterests(userId);
	}

}
