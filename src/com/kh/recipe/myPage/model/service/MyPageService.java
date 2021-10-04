package com.kh.recipe.myPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.mainPage.model.dto.Recipe;
import com.kh.recipe.myPage.model.dao.MyReviewDao;
import com.kh.recipe.myPage.model.dao.MyScrapeDao;

import com.kh.recipe.myPage.model.dto.Review;
import com.kh.recipe.myPage.model.dto.Scrape;

public class MyPageService {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	private MyReviewDao myReviewDao = new MyReviewDao();
	private MyScrapeDao myScrapeDao = new MyScrapeDao();

	public List<Recipe> selectMyRecipe(Scrape scrape) {

		Connection conn = template.getConnection();

		List<Recipe> myRecipes = null;

		try {
			myRecipes = myScrapeDao.selectMyRecipe(conn, scrape);
		} finally {
			template.close(conn);
		}

		return myRecipes;
	}

	public List<Review> selectMyReview(Review review) {
		Connection conn = template.getConnection();

		List<Review> myReviews = null;

		try {
			myReviews = myReviewDao.selectMyReview(conn, review);
		} finally {
			template.close(conn);
		}

		return myReviews;
	}

	public int cancelScrape(Scrape scrape) {
		
		int res = 0;
		Connection conn = template.getConnection();

		try {
			res = myScrapeDao.cancelScrape(conn, scrape);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			template.close(conn);
		}

		return res;

	}

	public int cancelReview(String userId, String reviewNo) {

		int res = 0;
		Connection conn = template.getConnection();

		try {
			res = MyReviewDao.cancelReview(conn, userId, reviewNo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			template.close(conn);
		}

		return res;

	}

	public int selReviewPageLength(Review review, int page) {
		int res = 0;

		Connection conn = template.getConnection();

		try {
			res = MyReviewDao.selReviewPageLength(conn, review, page);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			template.close(conn);
		}

		return res;

	}

	public int selScrapePageLength(Scrape scrape, int page) {
		int res = 0;

		Connection conn = template.getConnection();

		try {
			res = myScrapeDao.selScrapePageLength(conn, scrape, page);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			template.close(conn);
		}

		return res;
	}

}
