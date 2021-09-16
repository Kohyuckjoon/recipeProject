package com.kh.recipe.board.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Board {

	/*
	 * private String title; private String contents;
	 * 
	 * private HttpServletRequest request; private BoardService boardService = new
	 * BoardService();
	 * 
	 * private Map<String, String> failedAttribute = new HashMap<String, String>();
	 * 
	 * public Board(HttpServletRequest request) { this.request = request; this.title
	 * = request.getParameter("title"); this.contents =
	 * request.getParameter("contents"); }
	 * 
	 * public boolean test() {
	 * 
	 * boolean res = true; boolean vaild = true;
	 * 
	 * 
	 * // 게시글 제목 글자수 5-20자 vaild =
	 * Pattern.matches("^[a-zA-Zㄱ-힣0-9$@$!%*#?&]{5,20}$", title); if(!vaild) {
	 * failedAttribute.put("title", title); res = false; }
	 * 
	 * // 게시글 내용 글자수 5-500자 vaild =
	 * Pattern.matches("^[a-zA-Zㄱ-힣0-9$@$!%*#?&]{5,500}$", contents); if(!vaild) {
	 * failedAttribute.put("contents", contents); res = false; }
	 * 
	 * 
	 * if (!res) { request.getSession().setAttribute("boardFailed",
	 * failedAttribute); request.getSession().setAttribute("boardForm", this); this는
	 * public class JoinForm을 의미 }else {
	 * request.getSession().removeAttribute("boardFailed");
	 * request.getSession().removeAttribute("boardForm"); removeAttribute는 값 없어도 상관
	 * x. 있으면 지우고 }
	 * 
	 * return res;
	 * 
	 * }
	 * 
	 * public String getTitle() { return title; }
	 * 
	 * public String getContents() { return contents; }
	 * 
	 */

}
