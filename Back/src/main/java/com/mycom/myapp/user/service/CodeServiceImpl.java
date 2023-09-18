package com.mycom.myapp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dao.CodeDao;
import com.mycom.myapp.user.dto.CodeDto;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeDao dao;

	@Override
	public List<CodeDto> getCodeList(String code) {
		List<CodeDto> list = dao.getCodeList(code);
		
		return list;
	}

}