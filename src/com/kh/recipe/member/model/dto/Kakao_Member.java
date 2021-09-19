package com.kh.recipe.member.model.dto;

import java.sql.Date;

public class Kakao_Member {

	 private String userId;
	 private String userNickName;
	 private String grade;
	 private String userEmail;
	 private String tell;
	 private Date regDate;
	 private Date rentableDate;
	 private int isLeave;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRentableDate() {
		return rentableDate;
	}
	public void setRentableDate(Date rentableDate) {
		this.rentableDate = rentableDate;
	}
	public int getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}
	@Override
	public String toString() {
		return "Kakao_Member [userId=" + userId + ", userNickName=" + userNickName + ", grade=" + grade + ", userEmail="
				+ userEmail + ", tell=" + tell + ", regDate=" + regDate + ", rentableDate=" + rentableDate
				+ ", isLeave=" + isLeave + "]";
	}
	 
	
	
	
}
