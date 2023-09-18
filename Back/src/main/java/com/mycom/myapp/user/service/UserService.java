package com.mycom.myapp.user.service;

import com.mycom.myapp.user.dto.UserDto;
import com.mycom.myapp.user.dto.UserResultDto;

public interface UserService {
	UserResultDto userRegister(UserDto userDto);
	
	UserDto userProfile(int userSeq);
	
	UserResultDto userUpdate(UserDto dto);
	
	UserResultDto userDelete(int userSeq);
}
