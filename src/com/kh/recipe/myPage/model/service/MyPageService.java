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

	public List<Review> selectMyReview(String userId) {
		Connection conn = template.getConnection();

		List<Review> myReviews = null;
		
		try {
			myReviews = myReviewDao.selectMyReview(conn,userId);
		}finally {
			template.close(conn);
		}
		
		return myReviews;
	}

	

	

}
