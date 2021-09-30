package com.kh.recipe.member.model.dto;

import java.sql.Date;

public class Kakao_Member {

	 private String userId;
	 private String password;
	 private String userName;
	 private String userEmail;
	 private String phone;
	 private Date birth;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Kakao_Member [userId=" + userId + ", password=" + password + ", userName=" + userName + ", userEmail="
				+ userEmail + ", phone=" + phone + ", birth=" + birth + "]";
	}
	
	

	 
	
	
	
}
