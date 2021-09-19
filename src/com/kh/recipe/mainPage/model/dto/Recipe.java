package com.kh.recipe.mainPage.model.dto;

public class Recipe {
	
	private String rcpNm;
	// 메뉴명
	private String rcpPat2;
	// 요리종류
	private String attFileNoMk;
	// 요리 이미지
	public String getRcpNm() {
		return rcpNm;
	}
	public void setRcpNm(String rcpNm) {
		this.rcpNm = rcpNm;
	}
	public String getRcpPat2() {
		return rcpPat2;
	}
	public void setRcpPat2(String rcpPat2) {
		this.rcpPat2 = rcpPat2;
	}
	public String getAttFileNoMk() {
		return attFileNoMk;
	}
	public void setAttFileNoMk(String attFileNoMk) {
		this.attFileNoMk = attFileNoMk;
	}
	@Override
	public String toString() {
		return "Recipe [rcpNm=" + rcpNm + ", rcpPat2=" + rcpPat2 + ", attFileNoMk=" + attFileNoMk + "]";
	}
	
	
	

}
