package com.mycom.myapp.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.user.dto.CodeDto;

@Mapper
public interface CodeDao {
	List<CodeDto> getCodeList(String groupCode);
}