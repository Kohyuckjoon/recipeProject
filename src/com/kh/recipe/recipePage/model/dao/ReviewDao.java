package com.kh.recipe.recipePage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.recipePage.model.dto.Review;

public class ReviewDao {
	
	JDBCTemplate template = JDBCTemplate.getInstance();
	
	public List<Review> selectReview(Connection conn, int rcpSeq) {
		String sql = "select review_no, review_contents, user_id, review_date"
				+ " from review where rcp_seq = ?";

		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<Review> reviewList = new ArrayList<Review>();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, rcpSeq);
			rset = pstm.executeQuery();
			
			while (rset.next()) {

				Review review = new Review();
				review.setReviewNo(rset.getInt("review_no"));
				review.setRcpSeq(rset.getInt("rcp_seq"));
				review.setUserId(rset.getString("user_id"));
				review.setReviewContents(rset.getString("review_contents"));
				review.setReviewDate(rset.getDate("review_date"));
				reviewList.add(review);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			template.close(rset, pstm);
		}
		return reviewList;

	}

}
