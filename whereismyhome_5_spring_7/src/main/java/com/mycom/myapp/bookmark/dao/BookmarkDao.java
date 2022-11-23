package com.mycom.myapp.bookmark.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.bookmark.dto.BookmarkDto;

@Mapper
public interface BookmarkDao {
	List<BookmarkDto> bookmarkList(int userSeq);
	int bookmarkDelete(BookmarkDto	bookmarkDto);
	int bookmarkInsert(BookmarkDto	bookmarkDto);
}
