package com.kh.recipe.myPage.model.dto;

import java.sql.Date;

public class MyReview {

	private int reviewNo; // 댓글번호
	private int rcpSeq; // 레시피 번호
	private String userId; // 아이디
	private String reviewContents; // 댓글 내용
	private Date reviewDate; //댓글작성날짜
	private int rating; // 평점
	
	public MyReview() {
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "myReview [reviewNo=" + reviewNo + ", rcpSeq=" + rcpSeq + ", userId=" + userId + ", reviewContents="
				+ reviewContents + ", reviewDate=" + reviewDate + ", rating=" + rating + "]";
	}
	
	
	
}
