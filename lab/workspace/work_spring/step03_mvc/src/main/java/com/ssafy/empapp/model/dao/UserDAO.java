package com.ssafy.empapp.model.dao;

import java.sql.SQLException;

import com.ssafy.empapp.model.dto.User;

public interface UserDAO {

	String login(String userId, String password) throws SQLException;

	int register(User user) throws SQLException;

}