package com.kh.recipe.board.model.dto;

import java.sql.Date;

public class Board {

	private String no; //게시글 번호 -bdIdx
	private String userId; //아이디
	private String title; //게시글 제목
	private String content; //내용
	private Date regDate; //게시날짜
	private int viewCount; //조회수
	private int isDel;//삭제여부
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
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

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", userId=" + userId + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", viewCount=" + viewCount + ", isDel=" + isDel + "]";
	}

	



	
	
	
}
