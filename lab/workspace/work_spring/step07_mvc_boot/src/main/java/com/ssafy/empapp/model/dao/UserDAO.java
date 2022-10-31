package com.ssafy.empapp.model.dao;

import java.sql.SQLException;

public interface UserDAO {

	String login(String userId, String password) throws SQLException;

}