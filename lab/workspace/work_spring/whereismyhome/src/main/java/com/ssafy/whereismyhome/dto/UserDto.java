package com.ssafy.whereismyhome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	private String userId;
	private String userName;
	private String email;
	private String password;
	private String phoneNumber;
}
