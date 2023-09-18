package com.mycom.myapp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dao.UserDao;
import com.mycom.myapp.user.dto.UserDto;
import com.mycom.myapp.user.dto.UserResultDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
	@Override
	public UserResultDto userRegister(UserDto userDto) {
		UserResultDto userResultDto = new UserResultDto();
		 		
		if (userDao.userRegister(userDto) == 1) {
			userResultDto.setResult(SUCCESS);
		} else {
			userResultDto.setResult(FAIL);
		}

		return userResultDto;
	}

	@Override
	public UserDto userProfile(int userSeq) {
		UserDto dto = userDao.userProfile(userSeq);		
		
		return dto;
	}

	@Override
	public UserResultDto userUpdate(UserDto dto) {
		UserResultDto userResultDto = new UserResultDto();
		
		if (userDao.userUpdate(dto) == 1) {
			userResultDto.setResult(SUCCESS);
		} else {
			userResultDto.setResult(FAIL);
		}

		return userResultDto;
	}

	@Override
	public UserResultDto userDelete(int userSeq) {
		UserResultDto userResultDto = new UserResultDto();
		
		if(userDao.userDelete(userSeq)==1) {
			userResultDto.setResult(SUCCESS);
		} else {
			userResultDto.setResult(FAIL);
		}

		return userResultDto;
	}


}
