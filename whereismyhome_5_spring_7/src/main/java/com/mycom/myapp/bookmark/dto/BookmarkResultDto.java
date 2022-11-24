package com.mycom.myapp.bookmark.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookmarkResultDto {
	private int result;
	private List<BookmarkDto> list;
}
