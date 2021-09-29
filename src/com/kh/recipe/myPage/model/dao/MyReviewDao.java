package com.kh.recipe.myPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.myPage.model.dto.Review;

public class MyReviewDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Review> selectMyReview(Connection conn, String userId) {
		List<Review> myReviews = new ArrayList<Review>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select * from review where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Review review = convertAllToReview(rset);
				myReviews.add(review);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			template.close(rset, pstm);
		}
		
		return myReviews;
	}

	private Review convertAllToReview(ResultSet rset) throws SQLException {
		Review review = new Review();
		review.setReviewNo(rset.getInt("review_no"));
		review.setRcpSeq(rset.getInt("rcp_seq"));
		review.setUserId(rset.getString("user_id"));
		review.setReviewContents(rset.getString("review_contents"));
		review.setReviewDate(rset.getDate("review_date"));
		return review;
	}

}
