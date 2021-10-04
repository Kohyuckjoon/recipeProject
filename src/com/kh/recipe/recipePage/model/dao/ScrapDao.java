package com.kh.recipe.recipePage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.recipePage.model.dto.Scrap;

public class ScrapDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public int addScrap(Connection conn, Scrap scrap) {
		int res = 0;
		
		String sql = "insert into scrape(scr_index,user_id,rcp_seq) values(SCRAPE_SEQ.nextval,?,?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, scrap.getUserId());
			pstm.setInt(2, scrap.getRcpSeq());
			res = pstm.executeUpdate();
			template.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			template.close(pstm);
		}
		
		return res;
	}

}
