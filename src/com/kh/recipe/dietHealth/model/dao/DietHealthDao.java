package com.kh.recipe.dietHealth.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class DietHealthDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Recipe> selectSearchResult(Connection conn) throws SQLException {
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		String query = "select rcp_seq, att_file_no_mk, rcp_pat2, rcp_nm from recipe ";
		ResultSet rset = null;
		PreparedStatement pstm = null;
		
//		String query = "select rcp_seq," //요리 인덱스 필요하고
//				+ "rcpNm," //메뉴 이름(명) 필요하고
//				+ "attFileNoMk"  //요리 이미지 대
//				+ "rcpPat2"; //밥인지 뭔지 종류
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Recipe rec = new Recipe();
				rec.setRcpSeq(rset.getInt("rcp_seq")); // 인덱스
				rec.setAttFileNoMk(rset.getString("att_file_no_mk")); // 사진
				rec.setRcpPat2(rset.getString("rcp_pat2")); // 종류
				rec.setRcpNm(rset.getString("rcp_nm")); // 요리명
				recipes.add(rec);
			}
			
		} catch (Exception e) {
//			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR);
		} finally {
			template.close(rset,pstm);
		}
		return recipes;
	}

}
