package com.kh.recipe.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.member.model.dto.Kakao_Member;
import com.kh.recipe.member.model.dto.Member;
import com.kh.recipe.member.model.service.Kakao_MemberService;
import com.kh.recipe.member.model.service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService = new MemberService();
	private Kakao_MemberService kakao_memberService = new Kakao_MemberService();
	
    public MemberController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "login-form":
			loginForm(request,response);
			break;
		case "kakao-login":
			kakaoLogin(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		case "join-form":
			joinForm(request,response);
			break;
		case "join":
			join(request,response);
			break;
		case "id-check":
			checkID(request,response);
			break;
		case "kakao-join":
			kakaoJoin(request,response); 
			break;
		case "join-impl":
			joinImpl(request,response);
			break;
		case "mypage":
			mypage(request,response);
			break;
		case "login":
			login(request,response);
			break;
		case "delete-member":
			deleteMember(request,response);
			break;
		case "delete-form":
			deleteForm(request,response);
			break;

		default: throw new PageNotFoundException();
		
		}
	}
	

	private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/member/delete-form").forward(request, response);
		
	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		
		int member = memberService.deleteMember(userId, password);
		
		if(member != 0) {
			System.out.println(userId);
			request.getRequestDispatcher("/member/delete-member").forward(request, response);
			request.getSession().removeAttribute("authentication");
			
			response.sendRedirect("/mainPage/mainPage");
			//request.getRequestDispatcher("/member/delete-form").forward(request, response);
			return;
			
		}
	/*	else if(member != 0){
			request.getSession().removeAttribute("authentication");
			response.sendRedirect("/mainPage/mainPage");
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('계정이 삭제 되었습니다'); location.href='/mainPage/mainPage';</script>");
			 
			out.flush();
		}		
	*/	
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		  
		Member member = memberService.memberAuthenticate(userId, password);
		
		if(member != null) {
			System.out.println(member);
			response.sendRedirect("/mainPage/mainPage");
		}else {
			request.getRequestDispatcher("/member/login-form").forward(request, response);
			return;
		}
		request.getSession().setAttribute("authentication", member);  
		  
			
	}

	private void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/mypage").forward(request, response);
		
	}

	private void checkID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		Member member = memberService.selectMemberById(userId);
		if(member == null) {
			response.getWriter().print("available");
		}else {
			response.getWriter().print("disable");
		}
	}

	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		member.setName(name);
		member.setPhone(phone);
		member.setEmail(email);
		
		String persistToken = UUID.randomUUID().toString();
		request.getSession().setAttribute("persistUser", member);
		request.getSession().setAttribute("persistToken", persistToken);
		
		memberService.authenticateByEmail(member,persistToken);
		
		request.setAttribute("msg", "이메일이 발송 되었습니다.");
		request.setAttribute("url", "/mainPage/1");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}
	
	private void joinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		Member member = (Member) request.getSession().getAttribute("persistUser");
		memberService.insertMember(member);
		
		session.removeAttribute("persistToken");
		session.removeAttribute("persistUser");
		
		response.sendRedirect("/member/login-form");
		
		/*
		 * response.sendRedirect("/member/login-form"); String userId =
		 * request.getParameter("userId");
		 * 
		 * String password = request.getParameter("password"); String tell =
		 * request.getParameter("tell"); String email = request.getParameter("email");
		 */
		/*
		 * Member member = new Member(); member.setUserId(userId);
		 * member.setPassword(password); member.setTell(tell); member.setEmail(email);
		 */		
		/*
		 * memberService.insertMember(member);
		 * 
		 * response.sendRedirect("/member/login-form");
		 */
	}

	private void joinForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/member/join-form").forward(request, response);
	}
	
	  private void kakaoJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		  	
		String userId = request.getParameter("userId");
		String password = UUID.randomUUID().toString();
		String userName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String userEmail = request.getParameter("email");
		
		
		Kakao_Member kakao_member = new Kakao_Member();
		kakao_member.setUserId(userId);
		kakao_member.setPassword(password);
		kakao_member.setUserName(userName);
		kakao_member.setPhone(phone);
		kakao_member.setUserEmail(userEmail);
	  
	  	  
	  } 	  

	  
	  private void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
/*			
			String userId = request.getParameter("userId");
			String password = UUID.randomUUID().toString();
			
			Member member = memberService.selectMemberById(userId);
			if(member == null) {
				response.getWriter().print("available");
			}else {
				response.getWriter().print("disable");
			}
			String persistToken = UUID.randomUUID().toString();
*/			
			String userId = request.getParameter("userId"); 
			  
			Kakao_Member kakao_member = kakao_memberService.kakaomemberAuthenticate(userId);
			
			if(kakao_member != null) {
				System.out.println(kakao_member);
				response.sendRedirect("/mainPage/mainPage");
			}else {
				request.getRequestDispatcher("/member/login-form").forward(request, response);
				return;
			}
			request.getSession().setAttribute("authentication", kakao_member); 
			
			
			
			
			
			
		}
	

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getSession().removeAttribute("authentication");
		 response.sendRedirect("/mainPage/mainPage");
	}

	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		Member member = memberService.memberAuthenticate(userId, password);
		
		if(member != null) {
			//System.out.println(member);
			response.sendRedirect("/mainPage/mainPage");
		}else {
			request.getRequestDispatcher("/member/login-form").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("authentication", member);
		
		if(request.getAttribute(userId) != null) {
			request.getRequestDispatcher("/myPage/myPage").forward(request, response);
			return;
		}else {
			request.getRequestDispatcher("/mainPage/mainPage");
			return;
		}
		
		
		
		
	}

	
	

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
