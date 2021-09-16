package com.kh.recipe.member.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class JoinForm {

	/*
	 * private String userId; private String password; private String email; private
	 * String tell; private String name; private String year; private
	 * HttpServletRequest request; private MemberService memberService = new
	 * MemberService(); private Map<String, String> failedAttribute = new
	 * HashMap<String, String>();
	 * 
	 * public JoinForm(HttpServletRequest request) { this.request = request;
	 * this.userId = request.getParameter("userId"); this.password =
	 * request.getParameter("password"); this.email = request.getParameter("email");
	 * this.tell = request.getParameter("tell"); this.name =
	 * request.getParameter("name"); this.year = request.getParameter("year");
	 * 
	 * }
	 * 
	 * public boolean test() {
	 * 
	 * boolean res = true; boolean vaild = true;
	 * 
	 * 
	 * //db에 존재하지 않는 아이디인지 확인 if(memberService.selectMemberById(userId) != null) {
	 * failedAttribute.put("userId", userId); res = false; }
	 * 
	 * // 이메일-짜피 Form에서 걸러쥼. 중복검사도 굳이.
	 * 
	 * 
	 * //비밀번호가 영수특문 8-12자리 vaild = Pattern.matches(
	 * "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&](.{8,13}$)",
	 * password); if (!vaild) { failedAttribute.put("password", password); res =
	 * false; }
	 * 
	 * // 이름, 한글만. 1-5자 vaild = Pattern.matches("(?=.*[ㄱ-힣])(.{1,6})", name); if
	 * (!vaild) { failedAttribute.put("name", name); res = false; }
	 * 
	 * // 전화번호가 9-11자리 숫자 // 이스케이프문자니까 \하나 더 vaild = Pattern.matches("^\\d{9,11}$",
	 * tell); if (!vaild) { failedAttribute.put("tell", tell); res = false; }
	 * 
	 * 
	 * // 생년월일 // 연/월/일 // year까지는 저희가 validator 지정-숫자만,1900-2020까지? 월, 일은 옵션으로 받기
	 * vaild = Pattern.matches("^(19[0-9][0-9]|20[0-2][0-1])$", year); if (!vaild) {
	 * failedAttribute.put("year", year); res = false; }
	 * 
	 * if (!res) { request.getSession().setAttribute("joinFailed", failedAttribute);
	 * request.getSession().setAttribute("joinForm", this); this는 public class
	 * JoinForm을 의미 }else { request.getSession().removeAttribute("joinFailed");
	 * request.getSession().removeAttribute("joinForm"); removeAttribute는 값 없어도 상관
	 * x. 있으면 지우고 }
	 * 
	 * return res;
	 * 
	 * }
	 * 
	 * public String getUserId() { return userId; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public String getTell() { return tell; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public String getYear() { return year; }
	 */

}
