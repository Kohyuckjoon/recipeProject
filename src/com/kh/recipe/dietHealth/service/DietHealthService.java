package com.kh.recipe.dietHealth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.dietHealth.model.dao.DietHealthDao;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class DietHealthService {
	private DietHealthDao diteHelthDao = new DietHealthDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	//모든 레시피가 뜨게 하기
	public List<Recipe> selectSearchResult(String value) {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Connection conn = template.getConnection();
		
		try {
			Recipes = diteHelthDao.selectSearchResult(conn, value);
		} catch (DataAccessException | SQLException e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR); 
		}finally {
			template.close(conn);
		}
		return Recipes;
	}
	
	//checkBox check한 항목만 데이터 가져오기
//	public int checkBox() {
//		Connection conn = template.getConnection();
//		int checkList = 0;
//		
//		try {
//			checkList = diteHelthDao.selectCheckBoxList();
//		} catch (Exception e) {
//			template.rollback(conn);
//			throw e;
//		} finally {
//			template.close(conn);
//		}
//		
//		return checkList;
//	}
	
}
