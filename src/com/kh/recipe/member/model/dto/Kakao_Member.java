package com.kh.recipe.member.model.dto;

import java.sql.Date;

public class Kakao_Member {

	 private String userId;
	 private String userNickName;
	 private String userEmail;
	 private String phone;
	 private Date birth;
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Kakao_Member [userId=" + userId + ", userNickName=" + userNickName + ", userEmail=" + userEmail
				+ ", phone=" + phone + ", birth=" + birth + "]";
	}

	 
	
	
	
}
