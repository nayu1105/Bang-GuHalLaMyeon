package com.mycom.myapp.admin.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.admin.user.dto.AdminUserDto;
import com.mycom.myapp.admin.user.dto.AdminUserParamDto;

@Mapper
public interface AdminUserDao {
	List<AdminUserDto> userList(AdminUserParamDto adminUserParamDto);
	int userListTotalCnt();
}
