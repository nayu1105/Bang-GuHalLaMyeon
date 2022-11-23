package com.mycom.myapp.bookmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.bookmark.dao.BookmarkDao;
import com.mycom.myapp.bookmark.dto.BookmarkDto;
import com.mycom.myapp.bookmark.dto.BookmarkResultDto;

@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	BookmarkDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public BookmarkResultDto bookmarkList(int userSeq) {
		BookmarkResultDto bookmarkResultDto = new BookmarkResultDto();
		try {
			bookmarkResultDto.setList(dao.bookmarkList(userSeq));
			bookmarkResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			bookmarkResultDto.setResult(FAIL);
		}

		return bookmarkResultDto;
	}

	@Override
	public BookmarkResultDto bookmarkDelete(BookmarkDto	bookmarkDto) {
		BookmarkResultDto bookmarkResultDto = new BookmarkResultDto();
		try {
			int result = dao.bookmarkDelete(bookmarkDto);
			if (result == SUCCESS) {
				bookmarkResultDto.setResult(SUCCESS);
			} else {
				bookmarkResultDto.setResult(FAIL);
			}
		} catch (Exception e) {
			bookmarkResultDto.setResult(FAIL);
		}

		return bookmarkResultDto;
	}

	@Override
	public BookmarkResultDto bookmarkInsert(BookmarkDto bookmarkDto) {
		BookmarkResultDto bookmarkResultDto = new BookmarkResultDto();
		try {
			int result = dao.bookmarkInsert(bookmarkDto);
			if (result == SUCCESS) {
				bookmarkResultDto.setResult(SUCCESS);
			} else {
				bookmarkResultDto.setResult(FAIL);
			}
		} catch (Exception e) {
			bookmarkResultDto.setResult(FAIL);
		}

		return bookmarkResultDto;
	}
}
