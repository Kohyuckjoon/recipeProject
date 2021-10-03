package com.kh.recipe.myPage.model.dto;

import java.sql.Date;

public class Review {

	private int reviewNo; // 댓글번호
	private int rcpSeq; // 레시피 번호
	private String rcpNm; // 레시피 이름
	private String userId; // 아이디
	private String reviewContents; // 댓글 내용
	private Date reviewDate; //댓글작성날짜
	
	private int startIdx; // 각 페이지별로 글이 시작하는 번호
	private int rowCntPage; // 각 페이지당 출력할 글 개수
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	
	public int getStartIdx() {
		return startIdx;
	}



	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}



	public int getRowCntPage() {
		return rowCntPage;
	}



	public void setRowCntPage(int rowCntPage) {
		this.rowCntPage = rowCntPage;
	}



	public String getRcpNm() {
		return rcpNm;
	}

	public void setRcpNm(String rcpNm) {
		this.rcpNm = rcpNm;
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
		return "Review [reviewNo=" + reviewNo + ", rcpSeq=" + rcpSeq + ", rcpNm=" + rcpNm + ", userId=" + userId
				+ ", reviewContents=" + reviewContents + ", reviewDate=" + reviewDate + ", startIdx=" + startIdx
				+ ", rowCntPage=" + rowCntPage + "]";
	}

	


	
	
	
	
}
