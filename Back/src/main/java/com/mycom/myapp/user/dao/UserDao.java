package com.mycom.myapp.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.user.dto.UserDto;

@Mapper
public interface UserDao {
	int userRegister(UserDto userDto);
	
	UserDto userProfile(int userSeq);
	
	int userUpdate(UserDto dto);
	
	int userDelete(int userSeq);
}
