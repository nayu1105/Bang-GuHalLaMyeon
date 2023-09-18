package com.mycom.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;


@Mapper
public interface BoardDao {
	List<BoardDto> boardList();
	List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
	
	int boardListTotalCnt();
	int boardListSearchWordTotalCnt(String searchWord);
	
	BoardDto boardDetail(int boardId);
}

