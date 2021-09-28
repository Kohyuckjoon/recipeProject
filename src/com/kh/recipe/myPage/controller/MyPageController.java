package com.kh.recipe.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.member.model.dto.Member;
import com.kh.recipe.myPage.model.dto.Review;
import com.kh.recipe.myPage.model.service.MyPageService;

@WebServlet("/myPage/*")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyPageService myPageService = new MyPageService();
       
	public MyPageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "myPage":
			myPage(request,response);
			break;
		case "memberInfo":
			memberInfo(request,response);
			break;
		case "myReview":
			myReview(request,response);
			break;
		case "myScrape":
			myScrape(request,response);
			break;
		default: throw new PageNotFoundException();
		
		}
	}

	private void myScrape(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/myPage/myScrape").forward(request, response);
		
	}

	private void myReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = new Member();
		request.getSession().getAttribute("authentication");
		Review myReview = new Review();
		myReview.setUserId(member.getUserId());
		
		myPageService.selectReview(myReview);
		
		request.getRequestDispatcher("/myPage/myReview").forward(request, response);
		
	}

	private void memberInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/myPage/memberInfo").forward(request, response);
		
	}
	
	private void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/myPage/myPage").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
