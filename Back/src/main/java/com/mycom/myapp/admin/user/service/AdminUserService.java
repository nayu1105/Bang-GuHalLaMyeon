package com.mycom.myapp.admin.user.service;

import com.mycom.myapp.admin.user.dto.AdminUserDto;
import com.mycom.myapp.admin.user.dto.AdminUserParamDto;
import com.mycom.myapp.admin.user.dto.AdminUserResultDto;

public interface AdminUserService {
	AdminUserResultDto userList(AdminUserParamDto adminUserParamDto);
	AdminUserResultDto userDelete(int userSeq);
	AdminUserResultDto userUpdate(AdminUserDto adminUserDto);
}
