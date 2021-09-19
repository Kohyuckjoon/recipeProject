package com.kh.recipe.mainPage.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.mainPage.model.dao.MainPageDao;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class MainPageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	private MainPageDao mPD = new MainPageDao();
	
	public Map<String, Object> selectRecipeByDetail(String recipes) {
		Connection conn = template.getConnection();
		Map<String,Object> res = new HashMap<String, Object>();
		
		try {
			Recipe recipe = mPD.selectRecipeByDetail(conn, recipes);
			res.put("recipe", recipe);
		}finally {
			template.close(conn);
		}
			
		return res;
	}

}
