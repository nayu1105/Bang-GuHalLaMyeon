package com.mycom.myapp.bookmark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookmarkDto {
	private int bookmarkId;
	private long houseNo;
	private int userSeq;

	private long aptCode;
	private int buildYear;

	private String sidoName;
	private String gugunName;
	private String dongName;
	private String jibun;
	private String roadName;

	private String aptName;
	private String landCode;
	private String lng;
	private String lat;
}
