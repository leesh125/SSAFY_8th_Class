package com.ssafy.empapp.model.service;

import java.sql.SQLException;

public interface UserService {

	String login(String userId, String password) throws SQLException;

}