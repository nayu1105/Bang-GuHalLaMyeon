package com.mycom.myapp.board.service;

import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;

public interface BoardService {	
	BoardResultDto boardList(BoardParamDto boardParamDto);
	BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
	
	int boardListTotalCnt();
	int boardListSearchWordTotalCnt(String searchWord);
	
	BoardResultDto boardDetail(BoardParamDto boardParamDto);
}
