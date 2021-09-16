package com.kh.recipe.review.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Review {

	private String reviewContents;

	/*
	 * private HttpServletRequest request; private ReviewService reviewService = new
	 * ReviewService(); private Map<String, String> failedAttribute = new
	 * HashMap<String, String>();
	 * 
	 * public Review(HttpServletRequest request) { this.request = request;
	 * this.reviewContents = request.getParameter("reviewContents"); }
	 * 
	 * public boolean test() {
	 * 
	 * boolean res = true; boolean vaild = true;
	 * 
	 * 
	 * // 리뷰 글자수 5-100자 vaild = Pattern.matches("^[a-zA-Zㄱ-힣0-9$@$!%*#?&]{5,100}$",
	 * reviewContents); if(!vaild) { failedAttribute.put("reviewContents",
	 * reviewContents); res = false; }
	 * 
	 * 
	 * if (!res) { request.getSession().setAttribute("reviewFailed",
	 * failedAttribute); request.getSession().setAttribute("reviewForm", this);
	 * this는 public class JoinForm을 의미 }else {
	 * request.getSession().removeAttribute("reviewFailed");
	 * request.getSession().removeAttribute("reviewForm"); removeAttribute는 값 없어도 상관
	 * x. 있으면 지우고 }
	 * 
	 * return res;
	 * 
	 * }
	 * 
	 * public String getReviewContents() { return reviewContents; }
	 */

}
