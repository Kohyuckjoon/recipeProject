package com.kh.recipe.myPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.myPage.model.dto.Review;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

public class MyReviewDao {
	
	private static JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Review> selectMyReview(Connection conn, Review review) {
		List<Review> myReviews = new ArrayList<Review>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select review_no, rcp_seq, rcp_nm, user_id, review_contents, review_date "
				+ "from (select rownum as rnum, review_no, rcp_seq, rcp_nm, user_id, review_contents, review_date "
				+ "from review inner join recipe using (rcp_seq) "
				+ "where user_id = ? order by review_no asc) "
				+ "where rnum between ? and ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, review.getUserId());
			pstm.setInt(2, review.getStartIdx());
			pstm.setInt(3, review.getRowCntPage());
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				review = convertAllToReview(rset);
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

	public static int cancelReview(Connection conn, String userId, String reviewNo) {
		int res = 0;
	
		String sql = "delete from review where review_no = ? and user_id= ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, reviewNo);
			pstm.setString(2, userId);
			res = pstm.executeUpdate();
			template.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			template.close(pstm);
		}
		
		return res;
	}

	public static int selReviewPageLength(Connection conn, Review review, int page) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int res = 0;
		
		String sql = "select ceil(count(review_no)/?) from review where user_id=?";
		
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, (review.getRowCntPage()/page));
			pstm.setString(2, review.getUserId());
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

	private Review convertAllToReview(ResultSet rset) throws SQLException {
		Review review = new Review();
		review.setReviewNo(rset.getInt("review_no"));
		review.setRcpSeq(rset.getInt("rcp_seq"));
		review.setRcpNm(rset.getString("rcp_nm"));
		review.setUserId(rset.getString("user_id"));
		review.setReviewContents(rset.getString("review_contents"));
		review.setReviewDate(rset.getDate("review_date"));
		return review;
	}


	

}
