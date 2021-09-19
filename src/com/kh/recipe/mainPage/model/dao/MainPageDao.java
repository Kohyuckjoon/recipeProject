package com.kh.recipe.mainPage.model.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class MainPageDao {
	
	JDBCTemplate template = JDBCTemplate.getInstance();

	public Recipe selectRecipeByDetail(Connection conn, String recipes) {

		try {
			URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/9ee2439be26f471d9ffd/COOKRCP01/xml/1/100/");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		} catch (Exception e) {
			throw new HandlableException(ErrorCode.API_LODING_FAIL);
		}
		
		return null;
	}
}
