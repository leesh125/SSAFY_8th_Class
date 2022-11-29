package com.ssafy.model.service;

import java.sql.SQLException;

import com.ssafy.model.dao.UserDAO;
import com.ssafy.model.dto.User;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public String login(String userId, String password) throws SQLException {
		
		// 로그인 DB 작업
		return userDao.login(userId, password);
	}
	
	public boolean register(String userId, String password, String username, String address, String phoneNumber) throws SQLException {
		
		// 로그인 DB 작업
		return userDao.register(userId, password, username, address, phoneNumber) > 0;
	}

	public User getUser(String userId) throws SQLException {
		return userDao.getUser(userId);
		
	}

	public boolean update(String userId, String password, String username, String address) throws SQLException {
		return userDao.update(userId, password, username, address) > 0;
	}

	public boolean delete(String userId) throws SQLException {
		return userDao.delete(userId) > 0;
	}
}
