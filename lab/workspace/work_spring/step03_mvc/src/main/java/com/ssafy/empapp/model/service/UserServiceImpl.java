package com.ssafy.empapp.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDao;
	
	@Autowired
	public UserServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String login(String userId, String password) throws SQLException {
		
		// 濡쒓렇�씤 DB �옉�뾽
		return userDao.login(userId, password);
	}
}
