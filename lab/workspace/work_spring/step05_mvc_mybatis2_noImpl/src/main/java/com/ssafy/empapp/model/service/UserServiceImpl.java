package com.ssafy.empapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.UserDAO;
import com.ssafy.empapp.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDao;
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	} // Setter 주입


	@Override
	public String login(String userId, String password) throws Exception {

		// 로그인 DB 작업
		return userDao.login(userId, password);
		
	}
	
	@Override
	public boolean register(User user) throws Exception {

		// 로그인 DB 작업
		return userDao.register(user) > 0 ? true:false;
		
	}
	
}
