package com.kh.recipe.myPage.model.dto;

public class Scrape {

	private int scrIndex;
	private String userId;
	private int rcpSeq;
	
	private int startIdx; // 각 페이지별로 글이 시작하는 번호
	private int rowCntPage; // 각 페이지당 출력할 글 개수
	
	public Scrape() {
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
		return "Scrape [scrIndex=" + scrIndex + ", userId=" + userId + ", rcpSeq=" + rcpSeq + ", startIdx=" + startIdx
				+ ", rowCntPage=" + rowCntPage + "]";
	}



	
	

}
