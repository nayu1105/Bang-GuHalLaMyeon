package com.mycom.myapp.review.dto;

import java.time.LocalDateTime;

public class ReviewDto {

	private int reviewId;
	private int houseNo;
	private int rate;
	private int userSeq;
	private String userName;
	private String title;
	private String content;
	private LocalDateTime regDt;

	private int avgRate;

	public ReviewDto() {

	}

	public ReviewDto(int reviewId, int houseNo, int rate, int userSeq, String userName, String title, String content,
			LocalDateTime regDt, int avgRate) {
		super();
		this.reviewId = reviewId;
		this.houseNo = houseNo;
		this.rate = rate;
		this.userSeq = userSeq;
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.regDt = regDt;
		this.avgRate = avgRate;
	}

	public int getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(int avgRate) {
		this.avgRate = avgRate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "ReviewDto [reviewId=" + reviewId + ", houseNo=" + houseNo + ", rate=" + rate + ", userSeq=" + userSeq
				+ ", userName=" + userName + ", title=" + title + ", content=" + content + ", regDt=" + regDt
				+ ", avgRate=" + avgRate + "]";
	}

}
