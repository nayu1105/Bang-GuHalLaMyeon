package com.mycom.myapp.bookmark.service;

import com.mycom.myapp.bookmark.dto.BookmarkDto;
import com.mycom.myapp.bookmark.dto.BookmarkResultDto;

public interface BookmarkService {
	BookmarkResultDto bookmarkList(int userSeq);
	BookmarkResultDto bookmarkDelete(BookmarkDto bookmarkDto);
}
