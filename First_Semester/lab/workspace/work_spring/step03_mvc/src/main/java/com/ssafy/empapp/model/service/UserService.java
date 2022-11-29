package com.ssafy.empapp.model.service;

import com.ssafy.empapp.model.dto.User;

public interface UserService {

	String login(String userId, String password) throws Exception;

	boolean register(User user) throws Exception;

}