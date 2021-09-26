package com.kh.recipe.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
import com.kh.recipe.member.model.dto.Member;
import com.kh.recipe.member.model.service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService = new MemberService();
	
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
		case "normal-login":
			normalLogin(request,response);
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
		case "join-impl":
			joinImpl(request,response);
			break;
		case "mypage":
			mypage(request,response);
			break;
		case "login":
			login(request,response);
			break;

		default: throw new PageNotFoundException();
		
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/login").forward(request, response);
		
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

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getSession().removeAttribute("authentication");
		 response.sendRedirect("/mainPage/1");
	}

	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/member/login-form").forward(request, response);
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		Member member = memberService.memberAuthenticate(userId, password);
		request.getSession().setAttribute("authentication", member);
	}
	
	private void normalLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		Member member = memberService.memberAuthenticate(userId, password);
		
		//2. 사용자가 잘못된 아이디와 비밀번호를 입력한 경우
		//	 사용자에게 아이디나 비밀번호가 틀렸음을 알림, login-form으로 redirect 
		if(member == null) {
			response.sendRedirect("/member/login");
			return;
		}
		
		request.getSession().setAttribute("authentication", member);
		response.sendRedirect("/mainPage/1");
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
