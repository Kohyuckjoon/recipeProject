package com.kh.recipe.myPage.model.dto;

public class Scrape {

	private int index;
	private String userId;
	private int rcpSeq;
	

	public Scrape() {
		// TODO Auto-generated constructor stub
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRcpSeq() {
		return rcpSeq;
	}

	public void setRcpSeq(int rcpSeq) {
		this.rcpSeq = rcpSeq;
	}

	@Override
	public String toString() {
		return "Scrape [index=" + index + ", userId=" + userId + ", rcpSeq=" + rcpSeq + "]";
	}
	

}
