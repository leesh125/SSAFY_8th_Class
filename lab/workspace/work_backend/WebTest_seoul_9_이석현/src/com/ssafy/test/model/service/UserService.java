package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.model.dao.UserDAO;


public class UserService {
	private UserDAO userDao = new UserDAO();
	
	public boolean login(String userId, String password) throws SQLException {
		System.out.println(userId + " " + password);
		return userDao.login(userId, password);
	}
}
