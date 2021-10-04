package com.kh.recipe.recipePage.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.recipePage.model.dao.RecipeDao;
import com.kh.recipe.recipePage.model.dto.Recipe;

public class RecipePageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	private RecipeDao rPD = new RecipeDao();
	
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
	
	
	
	

	

}
