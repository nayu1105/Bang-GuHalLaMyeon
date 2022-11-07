package com.mycom.myapp.house.dto;

public class HouseParamDto {
	// Spring 에서 자동으로 파라미터 처리를 해주는 기능을 활용하기 위해
	// request.getParameter("limit")와 같은 코드를 생략하도록 별도의 dto를 만든다.

	// 게시글 목록
	private int limit;
	private int offset;
	private String searchWord;

	// house 상세
	private int houseSeq;
	private String sido;
	private String gugun;
	private String dong;
	private String aptName;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getHouseSeq() {
		return houseSeq;
	}

	public void setHouseSeq(int houseSeq) {
		this.houseSeq = houseSeq;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	@Override
	public String toString() {
		return "HouseParamDto [limit=" + limit + ", offset=" + offset + ", searchWord=" + searchWord + ", houseSeq="
				+ houseSeq + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", aptName=" + aptName + "]";
	}

}
