package com.mycom.myapp.admin.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.admin.board.dto.BoardDto;
import com.mycom.myapp.admin.board.dto.BoardParamDto;

@Mapper
public interface AdminBoardDao {
	int boardInsert(BoardDto dto);

	int boardUpdate(BoardDto dto);

	int boardDelete(int boardId);

	BoardDto boardDetail(int boardId);

	List<BoardDto> boardList(BoardParamDto boardParamDto);

	List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);

	int boardListTotalCnt();

	int boardListSearchWordTotalCnt(String searchWord);

}
