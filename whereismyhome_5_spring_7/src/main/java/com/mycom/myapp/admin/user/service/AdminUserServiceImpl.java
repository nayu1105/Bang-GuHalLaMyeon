package com.mycom.myapp.admin.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.admin.user.dao.AdminUserDao;
import com.mycom.myapp.admin.user.dto.AdminUserDto;
import com.mycom.myapp.admin.user.dto.AdminUserParamDto;
import com.mycom.myapp.admin.user.dto.AdminUserResultDto;

@Service
public class AdminUserServiceImpl implements AdminUserService{
	
	@Autowired
	AdminUserDao dao;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
	@Override
	public AdminUserResultDto userList(AdminUserParamDto adminUserParamDto) {
		AdminUserResultDto adminUserResultDto = new AdminUserResultDto();
		try {
			List<AdminUserDto> list = dao.userList(adminUserParamDto);
			int count = dao.userListTotalCnt();
			adminUserResultDto.setList(list);
			adminUserResultDto.setCount(count);
			adminUserResultDto.setResult(SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
			adminUserResultDto.setResult(FAIL);
		}	
		
		return adminUserResultDto;
	}

}
