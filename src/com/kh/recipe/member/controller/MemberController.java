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
		case "login":
			login(request,response);
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
		case "kakao-login":
			kakaoLogin(request,response);
			break;
		default: throw new PageNotFoundException();
		
		}
	}
	
	private void kakaoLogin(HttpServletRequest request, HttpServletResponse response) {
		
		String name = "";
		
		final String AUTH_HOST = "https://kauth.kakao.com";
	    final String tokenRequestUrl = AUTH_HOST + "/oauth/token";

	    String CLIENT_ID = "ba112efcf314ada7501dcec64b02b5f9"; // 해당 앱의 REST API KEY 정보. 개발자 웹사이트의 대쉬보드에서 확인 가능
	    String REDIRECT_URI = "localhost:9090/index"; // 해당 앱의 설정된 uri. 개발자 웹사이트의 대쉬보드에서 확인 및 설정 가능
	    String code = ""; // 로그인 과정중 얻은 authorization code 값
	    String getPersonalInfoUrl = "https://kapi.kakao.com/v2/user/me"; //로그인 후 사용자 정보를 받아오기 위한 url
	    String token_type = "token_type";

	    HttpsURLConnection conn = null;
	    OutputStreamWriter writer = null;
	    BufferedReader reader = null;
	    InputStreamReader isr= null;
	    URL url = null;
	    
	    try {
	      url = new URL(getPersonalInfoUrl);

	      conn = (HttpsURLConnection) url.openConnection();
	      conn.setRequestProperty("Authorization", "Bearer" + code);
	      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	      conn.setRequestProperty("charset", "utf-8");
	      
	      conn.setRequestMethod("POST");
	      conn.setDoOutput(true);

	      writer = new OutputStreamWriter(conn.getOutputStream());
	      writer.flush();
	   
	      final int responseCode = conn.getResponseCode();
	      System.out.println("Sending 'POST' request to URL : " + getPersonalInfoUrl);
	      System.out.println("Response Code : " + responseCode);

	      isr = new InputStreamReader(conn.getInputStream());
	      reader = new BufferedReader(isr);
	      final StringBuffer buffer = new StringBuffer();
	      String line;
	      while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	      }
	      String responseParam = buffer.toString();
	      System.out.println(responseParam);

	      name = responseParam.substring(responseParam.indexOf("nickname") + 11, responseParam.indexOf("profile_image") -3 );
	      System.out.println("name : " + name);
	      
	      //이후 DAO에서 알맞게 변환
	      
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	        // clear resources
	        if (writer != null) {
	          try {
	              writer.close();
	           } catch(Exception ignore) {
	           }
	        }
	        if (reader != null) {
	          try {
	              reader.close();
	          } catch(Exception ignore) {
	          }
	        }
	        if (isr != null) {
	            try {
	                isr.close();
	            } catch(Exception ignore) {
	            }
	         }
	    }
		
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
		
		String Id = request.getParameter("id");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setId(Id);
		member.setPassword(password);
		member.setPhone(phone);
		member.setEmail(email);
		
		String persistToken = UUID.randomUUID().toString();
		request.getSession().setAttribute("persistUser", member);
		request.getSession().setAttribute("persistToken", persistToken);
		
		memberService.authenticateByEmail(member,persistToken);
		
		request.setAttribute("msg", "이메일이 발송 되었습니다.");
		request.setAttribute("url", "/index");
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
		 response.sendRedirect("/index");
	}

	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/member/login").forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String userNickName = request.getParameter("userNickName");
		String password = request.getParameter("password");
		
		Member member = memberService.memberAuthenticate(userNickName, password);;
		
		//2. 사용자가 잘못된 아이디와 비밀번호를 입력한 경우
		//	 사용자에게 아이디나 비밀번호가 틀렸음을 알림, login-form으로 redirect 
		if(member == null) {
			response.sendRedirect("/member/login-form?err=1");
			return;
		}
		
		request.getSession().setAttribute("authentication", member);
		response.sendRedirect("/index");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
