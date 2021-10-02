package com.kh.recipe.myPage.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class MyScrapeDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Recipe> selectMyRecipe(Connection conn, String userId) {
		List<Recipe> myRecipes = new ArrayList<Recipe>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String columns = "rcp_seq, rcp_nm, rcp_pat2, att_file_no_mk";
		String query = "select " + columns +" from recipe inner join scrape using(rcp_seq) where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Recipe recipe = convertRowToRecipe(columns.split(","),rset);
				myRecipes.add(recipe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			template.close(rset, pstm);
		}
		
		return myRecipes;
	}

	public int cancelScrape(String userId, String rcpSeq, Connection conn) {
		Statement stmt = null;
		int res = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@db202109141233_high?TNS_ADMIN=C:/CODE/Wallet_DB202109141233", "ADMIN", "2whTpalvmf__");
			stmt = conn.createStatement();
			String query = "delete from scrape where user_id = '" + userId + "' " 
					+ "and rcp_seq = '" + rcpSeq + "'";
			res = stmt.executeUpdate(query);
		} catch (ClassNotFoundException | SQLException e) {
			 throw new DataAccessException(e);
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	private Recipe convertAllToRecipe(ResultSet rset) throws SQLException {
		Recipe recipe = new Recipe();
		recipe.setRcpSeq(rset.getInt("rcp_seq"));
		recipe.setRcpNm(rset.getString("rcp_nm"));
		recipe.setRcpPat2(rset.getString("rcp_pat2"));
		recipe.setAttFileNoMk(rset.getString("att_file_no_mk"));
		return recipe;
	}
	
	private Recipe convertRowToRecipe(String[] columns, ResultSet rset) throws SQLException {
		Recipe recipe = new Recipe();
		for (int i = 0; i < columns.length; i++) {			
			String column = columns[i].toLowerCase();
			column = column.trim();
			
			switch (column) {
			case "rcp_seq": recipe.setRcpSeq(rset.getInt("rcp_seq")); break;
			case "rcp_nm": recipe.setRcpNm(rset.getString("rcp_nm")); break;
			case "rcp_pat2" : recipe.setRcpPat2(rset.getString("rcp_pat2")); break;
			case "att_file_no_mk" : recipe.setAttFileNoMk(rset.getString("att_file_no_mk")); break;
		
			}
		}
		return recipe;
	}
	
	
}
