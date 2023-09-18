package com.mycom.myapp.admin.board.service;

import com.mycom.myapp.admin.board.dto.BoardDto;
import com.mycom.myapp.admin.board.dto.BoardParamDto;
import com.mycom.myapp.admin.board.dto.BoardResultDto;

public interface AdminBoardService {
	BoardResultDto boardInsert(BoardDto dto);	
	BoardResultDto boardUpdate(BoardDto dto);
	BoardResultDto boardDelete(int boardId);
	
	BoardResultDto boardList(BoardParamDto boardParamDto);
	BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
	
	int boardListTotalCnt();
	int boardListSearchWordTotalCnt(String searchWord);
	
	BoardResultDto boardDetail(BoardParamDto boardParamDto);
}
