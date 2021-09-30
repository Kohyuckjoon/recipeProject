package com.kh.recipe.dietHealth.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class dietHealthDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public List<Recipe> selectRecipeByDetail(Connection conn){
		List<Recipe> Recipe = new ArrayList<Recipe>();
		String query = "";
		ResultSet rset = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return Recipe;
	}

	
}
