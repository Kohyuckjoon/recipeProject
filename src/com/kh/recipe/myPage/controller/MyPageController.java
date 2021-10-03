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
import com.kh.recipe.mainPage.model.dto.Recipe;
import com.kh.recipe.member.model.dto.Member;
import com.kh.recipe.myPage.model.dto.Review;

import com.kh.recipe.myPage.model.dto.Scrape;
import com.kh.recipe.myPage.model.service.MyPageService;
import com.kh.recipe.recipePage.controller.RecipePageController;

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
		case "cancelScrape":
			cancelScrape(request,response);
			break;
		case "cancelReview":
			cancelReview(request,response);
			break;
			
		default: throw new PageNotFoundException();
		
		}
	}


	private void cancelReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = (Member) request.getSession().getAttribute("authentication");	
		
		String reviewNo = request.getParameter("reviewNo");
		
		Review review = new Review();
		review.setUserId(member.getUserId());
		String userId = review.getUserId(); 
		
		System.out.println(userId + "," + reviewNo);
		
		int res = myPageService.cancelReview(userId, reviewNo);
		
		System.out.println(res);
		
		if(res!=0) {
			response.sendRedirect("/myPage/myReview");
			
			return;
		}
		
	}

	private void cancelScrape(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = (Member) request.getSession().getAttribute("authentication");	
		
		String rcpSeq = request.getParameter("rcpSeq");
		
		Scrape scrape = new Scrape();
		scrape.setUserId(member.getUserId());
		String userId = scrape.getUserId();
		
		System.out.println(rcpSeq);
		System.out.println(userId);

		int res = myPageService.cancelScrape(userId, rcpSeq);
		
		System.out.println(res);
		
		if(res!=0) {
			response.sendRedirect("/myPage/myScrape");
			
			return;
		}
		
	}

	private void myScrape(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = (Member) request.getSession().getAttribute("authentication");
		
		if(member == null) {
			response.sendRedirect("/member/login");
			return;
		}
		
		String strPage = request.getParameter("page");
		int page = strPage == null ? 1 : Integer.parseInt(strPage);
		
		int rowCnt = 12;
		Scrape scrape = new Scrape();
		scrape.setUserId(member.getUserId());
		scrape.setRowCntPage(rowCnt*page);		
		scrape.setStartIdx(((page-1)*rowCnt)+1);
		
		int res = myPageService.selScrapePageLength(scrape, page);
		
		request.setAttribute("pageLength", res);
		
		
		List<Recipe> myRecipes = myPageService.selectMyRecipe(scrape);
		
		request.setAttribute("myRecipes", myRecipes);

		request.getRequestDispatcher("/myPage/myScrape").forward(request, response);
		
		
	}

	private void myReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = (Member) request.getSession().getAttribute("authentication");
		
		if(member == null) {
			response.sendRedirect("/member/login");
			return;
		}
		
		String strPage = request.getParameter("page");
		int page = strPage == null ? 1 : Integer.parseInt(strPage);
		
		int rowCnt = 10;
		Review review = new Review();
		review.setUserId(member.getUserId());
		review.setRowCntPage(rowCnt*page);		
		
		review.setStartIdx(((page-1)*rowCnt)+1);
		int res = myPageService.selReviewPageLength(review, page);
		
		request.setAttribute("pageLength", res);
		
		List<Review> myReviews = myPageService.selectMyReview(review);	
		
		request.setAttribute("myReviews", myReviews);
		
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
