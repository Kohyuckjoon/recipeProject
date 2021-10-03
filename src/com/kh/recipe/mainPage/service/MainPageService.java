package com.kh.recipe.mainPage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dao.MainPageDao;
import com.kh.recipe.mainPage.model.dto.Recipe;


public class MainPageService {
	
	private MainPageDao mPD = new MainPageDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public List<Recipe> selectRecipeByDetail() {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Connection conn = template.getConnection();
		
		try {
			Recipes = mPD.selectRecipeByDetail(conn);
		} catch (DataAccessException | SQLException e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR); 
		}finally {
			template.close(conn);
		}
		return Recipes;
	}

	public int insertRecipe() {
		
		Connection conn = template.getConnection();
		int succes = 0;
		
		try {
			succes = mPD.insertRecipe(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		}finally {
			template.close(conn);
		}
		
		return  succes;
	}
		
	

}
