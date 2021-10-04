package com.kh.recipe.board.model.dto;

import java.sql.Date;

public class Board {

	private int no; //게시글 번호 -bdIdx
	private String userId; //아이디
	private String title; //게시글 제목
	private String content; //내용
	private Date regDate; //게시날짜
	private int viewCount; //조회수
	private int startIdx; // 각 페이지별로 글이 시작하는 번호
	private int rowCntPage; // 각 페이지당 출력할 글 개수

	
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


	public Board() {
		// TODO Auto-generated constructor stub
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getViewCount() {
		return viewCount;
	}


	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}


	@Override
	public String toString() {
		return "Board [no=" + no + ", userId=" + userId + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", viewCount=" + viewCount + "]";
	}





	
	

	
	
	
}
