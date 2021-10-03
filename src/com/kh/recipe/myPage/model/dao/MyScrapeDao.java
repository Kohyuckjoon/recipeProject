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
import com.kh.recipe.myPage.model.dto.Scrape;

public class MyScrapeDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Recipe> selectMyRecipe(Connection conn, Scrape scrape) {
		List<Recipe> myRecipes = new ArrayList<Recipe>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String columns = "rcp_seq, rcp_nm, rcp_pat2, att_file_no_mk";
		
		String query = "select " + columns + " from (select rownum as rnum, " + columns + " from recipe inner join scrape using(rcp_seq) "
				+ "where user_id = ? order by scr_index asc) "
				+ "where rnum between ? and ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, scrape.getUserId());
			pstm.setInt(2, scrape.getStartIdx());
			pstm.setInt(3, scrape.getRowCntPage());
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
		
		int res = 0;
		
		String sql = "delete from scrape where user_id= ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
			template.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			template.close(pstm);
		}
		
		return res;

	}
	
	public int selScrapePageLength(Connection conn, Scrape scrape, int page) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int res = 0;
		
		String sql = "select ceil(count(scr_index)/?) from scrape where user_id = ?";
		
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, (scrape.getRowCntPage()/page));
			pstm.setString(2, scrape.getUserId());
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				res = rset.getInt(1);
			}
			
			template.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			template.close(pstm);
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
