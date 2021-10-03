package com.kh.recipe.myPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.mainPage.model.dto.Recipe;
import com.kh.recipe.myPage.model.dao.MyReviewDao;
import com.kh.recipe.myPage.model.dao.MyScrapeDao;

import com.kh.recipe.myPage.model.dto.Review;

public class MyPageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	private MyReviewDao myReviewDao = new MyReviewDao();
	private MyScrapeDao myScrapeDao = new MyScrapeDao();
	
	public List<Recipe> selectMyRecipe(String userId) {

		Connection conn = template.getConnection();

		List<Recipe> myRecipes = null;
		
		try {
			myRecipes = myScrapeDao.selectMyRecipe(conn,userId);
		}finally {
			template.close(conn);
		}
		
		return myRecipes;
	}

	public List<Review> selectMyReview(Review review) {
		Connection conn = template.getConnection();

		List<Review> myReviews = null;
		
		try {
			myReviews = myReviewDao.selectMyReview(conn,review);
		}finally {
			template.close(conn);
		}
		
		return myReviews;
	}

	public int cancelScrape(String userId, String rcpSeq) {
		
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = myScrapeDao.cancelScrape(userId, rcpSeq, conn);
			template.commit(conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			template.rollback(conn);
		}
		
		return res;
		
		
	}

	public int cancelReview(String userId, String reviewNo) {

		int res = 0;
		  Connection conn =template.getConnection();
		   
		  try {
			  res = MyReviewDao.cancelReview(conn,userId,reviewNo);
			
		  }catch (Exception e) {
			  e.printStackTrace();
		  }finally { 
			  template.close(conn); 
		  } 
		  
		  return res;
		
	}

	public int selPageLength(Review review, int page) {
		int res = 0;  
		
		Connection conn =template.getConnection();
		   
		  try {
			 res = MyReviewDao.selPageLength(conn,review,page);
			
		  }catch (Exception e) {
			  e.printStackTrace();
		  }finally { 
			  template.close(conn); 
		  } 
		  
		  return res;
		
	}

	

	

	

}
