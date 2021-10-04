package com.kh.recipe.recipePage.model.dto;

import java.sql.Date;

public class Comments {
	
	private int commentNo;
	private int no;
	private String userId;
	private String commentContent;
	private Date commentDate;
	// sql date?
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comments [commentNo=" + commentNo + ", no=" + no + ", userId=" + userId + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + "]";
	}
	
	

}
