package com.kh.recipe.board.model.dto;

public class BoardDTO {

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
	
}
