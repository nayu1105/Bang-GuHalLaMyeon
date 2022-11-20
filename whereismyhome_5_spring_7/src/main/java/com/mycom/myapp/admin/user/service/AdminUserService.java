package com.mycom.myapp.admin.user.service;

import com.mycom.myapp.admin.user.dto.AdminUserParamDto;
import com.mycom.myapp.admin.user.dto.AdminUserResultDto;

public interface AdminUserService {
	AdminUserResultDto userList(AdminUserParamDto adminUserParamDto);
}
