package com.kh.recipe.mainPage.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dao.MainPageDao;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class MainPageService {
	
	private MainPageDao mPD = new MainPageDao();
	
	public List<Recipe> selectRecipeByDetail() {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		
		try {
			Recipes = mPD.selectRecipeByDetail();
		} catch (DataAccessException e) {
			throw new HandlableException(ErrorCode.API_LODING_FAIL);
		}
		return Recipes;
	}

}
