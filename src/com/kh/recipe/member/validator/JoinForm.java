package com.kh.recipe.member.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

public class JoinForm {
	
	private String id;
	private String password;
	private String email;
	private String phone;
	private HttpServletRequest request;
	/* private MemberService memberService = new MemberService(); */
	private Map<String, String> failedAttribute = new HashMap<String, String>();
	
	public JoinForm(HttpServletRequest request) {
		this.request = request;
		this.id = request.getParameter("id");
		this.password = request.getParameter("password");
		this.email = request.getParameter("email");
		this.phone = request.getParameter("phone");
	}
	
	public boolean test() {
		
		boolean res = true;
		boolean vaild = true;
		
		
		//db에 존재하지 않는 아이디인지 확인
		/*
		 * if(memberService.selectMemberById(userId) != null) {
		 * failedAttribute.put("userId", userId); res = false; }
		 */
					
		//비밀번호가 영수특문 8자리
		vaild = Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9])(.{8,})", password);
		if (!vaild) {
			failedAttribute.put("password", password);
			res = false;
		}
							
		// 전화번호가 9-11자리 숫자
		// 이스케이프문자니까 \하나 더
		vaild =  Pattern.matches("^\\d{9,11}$", phone);
		if (!vaild) {
			failedAttribute.put("phone", phone);
			res = false;
		}
		
		if (!res) {
			request.getSession().setAttribute("joinFailed", failedAttribute);
			request.getSession().setAttribute("joinForm", this);
			/* this는 public class JoinForm을 의미 */
		}else {
			request.getSession().removeAttribute("joinFailed");
			request.getSession().removeAttribute("joinForm");
			/* removeAttribute는 값 없어도 상관  x. 있으면 지우고 */
		}
			
		return res;
	
	
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}


	

}
