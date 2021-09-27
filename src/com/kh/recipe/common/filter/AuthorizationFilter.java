package com.kh.recipe.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.member.model.dto.Member;

public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		
		//  /member/join  =>  [ , member, join]
		if(uriArr.length != 0) {
			
			switch (uriArr[1]) {
			case "member":
				memberAuthorize(httpRequest, httpResponse, uriArr);
				break;
//			case "admin":
//				adminAuthorize(httpRequest, httpResponse, uriArr);
//				break;
			
			 case "board":
				 boardAuthorize(httpRequest, httpResponse, uriArr);
				 break;
			 
			}
			
		}
		chain.doFilter(request,response);
	}

	
	  private void boardAuthorize(HttpServletRequest httpRequest,
	  HttpServletResponse httpResponse, String[] uriArr) { HttpSession session =
	  httpRequest.getSession(); Member member= (Member)
	  session.getAttribute("authentication"); switch (uriArr[2]) { 
	  case
	  "board-form": 
		  if(member==null) { 
			  throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR); } break;
	  case "upload": 
				  if(member==null) {
					  throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR); 
			} break;
	  
	 }
	  
	  }
	 
//	private void adminAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
//		
//		HttpSession session = httpRequest.getSession();
//		Member member= (Member) session.getAttribute("authentication");
//		
//		// 비회원과, 사용자 회원인지를 판단
//		if(member == null || MemberGrade.valueOf(member.getGrade()).ROLE.equals("user")) {
//			throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
//		}
//		
//		//슈퍼관리자인지 판단해 슈퍼관리자라면 모든 admin페이지에 접근할 수 있다.
//		if(MemberGrade.valueOf(member.getGrade()).DESC.equals("super")) {
//			return;
//		}
//		switch (uriArr[2]) {
//		case "member":
//			if(!MemberGrade.valueOf(member.getGrade()).DESC.equals("member")) {
//				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
//			}
//			break;
//		case "board":
//			if(!MemberGrade.valueOf(member.getGrade()).DESC.equals("board")) {
//				throw new HandlableException(ErrorCode.UNAUTHORIZED_PAGE_ERROR);
//			}
//			break;
//
//		default:
//			break;
//		}
//		
//	}

	private void memberAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		HttpSession session = httpRequest.getSession();
		switch (uriArr[2]) {
		
		case "join-impl":
			String serverToken = (String)session.getAttribute("persistToken");
			String clientToken = httpRequest.getParameter("persistToken");
			
			if(serverToken == null || !serverToken.equals(clientToken)) {
				throw new HandlableException(ErrorCode.AUTHENTICATION_FAILED_ERROR);
			}
			
			break;
		case "mypage":
			if(session.getAttribute("authentication") == null) {
				throw new HandlableException(ErrorCode.REDIRECT.setURL("/member/login-form"));
			}
			
			break;
			
		default:
			break;
		}

		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
