package com.kh.recipe.recipePage.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.recipePage.model.dao.RecipeReviewDao;
import com.kh.recipe.recipePage.model.dao.ScrapDao;
import com.kh.recipe.recipePage.model.dao.RecipeDao;
import com.kh.recipe.recipePage.model.dto.Recipe;
import com.kh.recipe.recipePage.model.dto.Review;
import com.kh.recipe.recipePage.model.dto.Scrap;

public class RecipePageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	private RecipeDao rPD = new RecipeDao();
	private RecipeReviewDao cDao = new RecipeReviewDao();
	private ScrapDao sDao = new ScrapDao();
	
	public List<Recipe> selectRecipeByDetail() {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Connection conn = template.getConnection();
		
		try {
			Recipes = rPD.selectRecipeByDetail(conn);
		} catch (DataAccessException e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR); 
		}finally {
			template.close(conn);
		}
		return Recipes;
		
	}

	public List<Recipe> selectRecipeByDetailToScrape(Recipe recipe) {
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Connection conn = template.getConnection();
		
		try {
			Recipes = rPD.selectRecipeByDetailToScrape(conn, recipe);
		} catch (DataAccessException e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR); 
		}finally {
			template.close(conn);
		}
		return Recipes;
	}

	public List<Review> selectReplyByDetail(int no) {
		
		List<Review> comments = new ArrayList<Review>();
		Connection conn = template.getConnection();
		
		try {
			comments = cDao.selectCommentsByDetail(conn, no);
		} catch (DataAccessException e) {
			e.printStackTrace();
			/* throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR); */
		}finally {
			template.close(conn);
		}
		return comments;
	}

	public void uploadReview(Review review) {
		Connection conn = template.getConnection();

		try {
			cDao.uploadReview(conn, review);
			template.commit(conn);
		} catch (DataAccessException e) {
			template.rollback(conn);
			throw e;
		}finally {
			template.close(conn);
		}
		
	}

	public int addScrap(Scrap scrap) {
		int res = 0;
		Connection conn = template.getConnection();

		try {
			res = sDao.addScrap(conn, scrap);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			template.close(conn);
		}

		return res;
		}

	}

