package com.kh.recipe.recipePage.model.dto;

import java.sql.Date;

public class Review {
	
	private int reviewNo;
	private int rcpSeq;
	private String userId;
	private String reviewContents;
	private Date reviewDate;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getRcpSeq() {
		return rcpSeq;
	}

	public void setRcpSeq(int rcpSeq) {
		this.rcpSeq = rcpSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", rcpSeq=" + rcpSeq + ", userId=" + userId + ", reviewContents="
				+ reviewContents + ", reviewDate=" + reviewDate + "]";
	}

}
