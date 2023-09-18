package com.mycom.myapp.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.user.dto.UserDto;

@Mapper
public interface LoginDao {
	UserDto login(String userEmail);
}
