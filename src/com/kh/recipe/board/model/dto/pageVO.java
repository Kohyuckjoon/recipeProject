package com.kh.recipe.board.model.dto;



public class pageVO {
	private int startPage; //게시글 화면 첫번째 번호
	private int endPage; //게시글 화면 마지막 번호
	private boolean prev,next; //이전, 다음
	private int pageNum;
	private int amount = 10; //화면에 뿌려질 데이터
	private int total; //전체 게시글 수 
	
	public void PageVO(int pageNum ,  int amount, int total) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.total = total;
		
		this.endPage = (int)Math.ceil(this.pageNum * 0.1)*10;
		this.startPage = this.endPage - 10 + 1;
		
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		
		System.out.println("시작 페이지 "+ this.startPage + "끝페이지" + this.endPage);
	}
	
	
}
