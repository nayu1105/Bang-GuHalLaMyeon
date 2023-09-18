package com.mycom.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.board.dao.BoardDao;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			// 목록, 총건수를 가져온다.
			List<BoardDto> list = dao.boardList();
			int count = dao.boardListTotalCnt();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}
	
	@Override
	public int boardListTotalCnt() {
		return dao.boardListTotalCnt();
	}
	
	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			BoardDto boardDto = dao.boardDetail(boardParamDto.getBoardId());
			// 두 사용자가 같은지에 대한 sameUser 처리
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);
			return boardResultDto;
		}catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}
	

}