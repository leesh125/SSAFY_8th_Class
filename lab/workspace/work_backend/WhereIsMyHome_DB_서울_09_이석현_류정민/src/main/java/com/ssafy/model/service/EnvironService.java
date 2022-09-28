package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.EnvironDAO;
import com.ssafy.model.dto.Environ;

public class EnvironService {

	EnvironDAO environDao = new EnvironDAO();
	
	public List<Environ> getEnvironsByDong(String dongCode) throws SQLException {
		return environDao.getEnvironsByDong(dongCode);
	}
}
