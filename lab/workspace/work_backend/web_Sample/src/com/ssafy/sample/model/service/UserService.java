package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.model.dao.UserDAO;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public String login(String userId, String password) throws SQLException {
		
		// 로그인 DB 작업
		return userDao.login(userId, password);
	}
}

