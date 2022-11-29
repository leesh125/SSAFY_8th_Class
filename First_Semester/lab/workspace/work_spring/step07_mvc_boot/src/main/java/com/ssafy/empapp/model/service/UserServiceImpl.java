package com.ssafy.empapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.empapp.model.dao.UserDAO;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDao;
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Transactional(readOnly = true)
	@Override
	public String login(String userId,String password) throws Exception {
	
		// 로그인 DB 작업
		return userDao.login(userId, password);
	}
}
