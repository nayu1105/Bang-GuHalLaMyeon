package com.mycom.myapp.admin.user.dto;

public class AdminUserParamDto {

	private int limit;
	private int offset;

	private int userSeq;

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

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	@Override
	public String toString() {
		return "AdminUserParamDto [limit=" + limit + ", offset=" + offset + ", userSeq=" + userSeq + "]";
	}

}
