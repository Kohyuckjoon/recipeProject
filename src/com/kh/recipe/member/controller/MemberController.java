package com.kh.recipe.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
		case "update-password-form":
			updatePasswordForm(request,response);	
			break;	
		case "update-name-form":
			updateNameForm(request,response);	
			break;	
		case "update-email-form":
			updateEmailForm(request,response);	
			break;	
		case "update-phone-form":
			updatePhoneForm(request,response);	
			break;	
		case "update-member-password":
			updateMemeberPassword(request,response);
			break;
		case "update-member-name":
			updateMemeberName(request,response);
			break;
		case "update-member-phone":
			updateMemeberPhone(request,response);
			break;
		case "update-member-email":
			updateMemeberEmail(request,response);
			break;
		default: throw new PageNotFoundException();
		
		}
	}
	
	private void updatePhoneForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/update-phone-form").forward(request, response);
		
	}

	private void updateEmailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/update-email-form").forward(request, response);
		
	}

	private void updateNameForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/update-name-form").forward(request, response);
		
	}

	private void updatePasswordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/update-password-form").forward(request, response);
		
	}
	
	private void updateMemeberEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		int member = memberService.updateMemeberEmail(userId, password, email);
		
		if(member != 0) {
			System.out.println(email);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이메일이 변경되었습니다.'); </script>");
			out.flush();
			request.getRequestDispatcher("/myPage/memberInfo").forward(request, response);
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('이메일이 변경되지 않았습니다. 아이디, 비밀번호를 확인해주세요'); location.href='/myPage/memberInfo#tab2'</script>");
			 
			out.flush();

		}
		
	}

	private void updateMemeberPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		
		int member = memberService.updateMemeberPhone(userId, password, phone);
		
		if(member != 0) {
			System.out.println(phone);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('전화번호가 변경되었습니다.'); </script>");
			out.flush();
			request.getRequestDispatcher("/myPage/memberInfo#tab1").forward(request, response);
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('전화번호가 변경되지 않았습니다. 아이디, 비밀번호를 확인해주세요'); location.href='/myPage/memberInfo#tab2'</script>");
			out.flush();

		}
		
	}

	
	private void updateMemeberName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		int member = memberService.updateMemeberName(userId, password, name);
		
		if(member != 0) {
			System.out.println(name);
			System.out.println(member);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이름이 변경되었습니다.'); location.href='/myPage/memberInfo' </script>");
			out.flush();
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이름이 변경되지 않았습니다. 아이디, 비밀번호를 확인해주세요'); location.href='/myPage/memberInfo#tab2'</script>");
			out.flush();

		}
		
	}


	private void updateMemeberPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		String changepassword = request.getParameter("changepassword");
		
		int member = memberService.updateMemeberPassword(userId, password, changepassword);
		
		if(member != 0) {
			System.out.println(changepassword);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 변경되었습니다.'); location.href='/myPage/memberInfo' </script>");
			out.flush();
			
		
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 변경되지 않았습니다. 아이디, 비밀번호를 확인해주세요'); location.href='/myPage/memberInfo#tab2'</script>");
			out.flush();

		}
		
	}
	
	
	
	

	private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/delete-form").forward(request, response);
		
	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId"); 
		String password = request.getParameter("password");
		
		int member = memberService.deleteMember(userId, password);
		
		if(member != 0) {
			System.out.println(userId);
			PrintWriter out = response.getWriter();
			out.println("<script>alert('계정이 삭제 되었습니다.'); location.href='/mainPage/mainPage';</script>");
			out.flush();

			request.getSession().removeAttribute("authentication");
			response.sendRedirect("/mainPage/mainPage");

			return;
			
		}else {
			System.out.println(userId);
			System.out.println(password);
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디, 비밀번호를 확인해주세요.'); location.href='history.back()'; </script>");
			out.flush();

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
		request.setAttribute("url", "/mainPage/mainPage");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}
	
	private void joinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		Member member = (Member) request.getSession().getAttribute("persistUser");
		memberService.insertMember(member);
		
		session.removeAttribute("persistToken");
		session.removeAttribute("persistUser");
		
		//response.sendRedirect("/mainPage/mainPage");
		response.sendRedirect("/mainPage");
		//request.getRequestDispatcher("/member/join").forward(request, response);
		
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
