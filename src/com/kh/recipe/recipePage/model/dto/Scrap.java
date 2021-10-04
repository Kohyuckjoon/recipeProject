package com.kh.recipe.recipePage.model.dto;

public class Scrap {
	
	private int scrIndex;
	private String userId;
	private int rcpSeq;
	
	public Scrap() {
		// TODO Auto-generated constructor stub
	}

	

	public int getScrIndex() {
		return scrIndex;
	}



	public void setScrIndex(int scrIndex) {
		this.scrIndex = scrIndex;
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
		return "Scrap [scrIndex=" + scrIndex + ", userId=" + userId + ", rcpSeq=" + rcpSeq + "]";
	}

	

}
