package com.kh.recipe.board.model.dto;

import java.util.List;

public class paging {
	private int curPage = 1;// 현재페이지 입력값이 없으면 1페이지
	private int perPage = 10;// 한 페이지에서 보여줄 최대 글목록 수
	private int perLine = 10;// 페이지를 이동할 수 있는 보여질 페이지 목록 단위
	private int amount;	// DB에 입력된 총 글의 수
	private int totalPage;// 글의 목록을 보여줄 총 페이지 수
	private int startNum;// 한 페이지의 보여줄 처음 글의 rownum
	private int endNum;// 한 페이지에서 보여줄 마지막 글의 rownum  
	//private List<BoardDto> list;// 글목록을 담을 리스트
	private int beginLineNum;// 페이지 목록의 보여줄 처음 수  
	private int stopLineNum;// 페이지 목록의 보여줄 마지막 수
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerLine() {
		return perLine;
	}
	public void setPerLine(int perLine) {
		this.perLine = perLine;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getBeginLineNum() {
		return beginLineNum;
	}
	public void setBeginLineNum(int beginLineNum) {
		this.beginLineNum = beginLineNum;
	}
	public int getStopLineNum() {
		return stopLineNum;
	}
	public void setStopLineNum(int stopLineNum) {
		this.stopLineNum = stopLineNum;
	}

	
	
}
