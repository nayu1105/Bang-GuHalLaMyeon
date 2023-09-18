package com.mycom.myapp.admin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.admin.board.dao.AdminBoardDao;
import com.mycom.myapp.admin.board.dto.BoardDto;
import com.mycom.myapp.admin.board.dto.BoardParamDto;
import com.mycom.myapp.admin.board.dto.BoardResultDto;


@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	AdminBoardDao dao;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public BoardResultDto boardInsert(BoardDto dto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		boardResultDto.setResult( dao.boardInsert(dto));
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardUpdate(BoardDto dto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		boardResultDto.setResult( dao.boardUpdate(dto));
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDelete(int boardId) {
		BoardResultDto boardResultDto = new BoardResultDto();
		boardResultDto.setResult( dao.boardDelete(boardId));
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			// 목록, 총건수를 가져온다.
			List<BoardDto> list = dao.boardList(boardParamDto);
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
	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
		
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			// 목록, 총건수를 가져온다.
			List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
			int count = dao.boardListSearchWordTotalCnt(boardParamDto.getSearchWord());
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
	public int boardListSearchWordTotalCnt(String searchWord) {
		return dao.boardListSearchWordTotalCnt(searchWord);
	}

	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			BoardDto boardDto = dao.boardDetail(boardParamDto.getBoardId());
			// 두 사용자가 같은지에 대한 sameUser 처리
			if (boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			} else {
				boardDto.setSameUser(false);
			}
			boardResultDto.setDto(boardDto);
			return boardResultDto;
		}catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}
	
	

}
