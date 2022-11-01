package com.ssafy.whereismyhome.service;

import java.util.List;

import com.ssafy.whereismyhome.dto.UserDto;

public interface UserService {

	List<UserDto> getUsers();

	UserDto getUser(String userId);

	boolean registerUser(UserDto user);

	boolean modifyUser(UserDto user);

	boolean delteUser(String userId);

}
