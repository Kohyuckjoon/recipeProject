package com.kh.recipe.mainPage.model.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class MainPageDao {
	

	public List<Recipe> selectRecipeByDetail() {
		
		String value = "";
		List<Recipe> Recipes = new ArrayList<Recipe>();
		
		try {
			URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/9ee2439be26f471d9ffd/COOKRCP01/json/1/1000");
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			value = br.readLine();

			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(value);
			JSONObject COOKRCP01 = (JSONObject) object.get("COOKRCP01");
			JSONArray recipeArray = (JSONArray) COOKRCP01.get("row");

			for (int i = 0; i < recipeArray.size(); i++){
				Recipe recipe = new Recipe();
				
				JSONObject recipeDetail = (JSONObject) recipeArray.get(i);
				recipe.setRcpSeq(recipeDetail.get("RCP_SEQ").toString()); // 인덱스
				recipe.setAttFileNoMk(recipeDetail.get("ATT_FILE_NO_MK").toString()); // 사진
				recipe.setRcpPat2(recipeDetail.get("RCP_PAT2").toString()); // 종류
				recipe.setRcpNm(recipeDetail.get("RCP_NM").toString()); // 요리명
				
				Recipes.add(recipe);

			}

		} catch (Exception e) {
			throw new HandlableException(ErrorCode.API_LODING_FAIL);
		}
		
		return Recipes;

	}
}
