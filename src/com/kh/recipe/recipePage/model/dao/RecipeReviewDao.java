package com.kh.recipe.recipePage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dto.Recipe;
import com.kh.recipe.recipePage.model.dto.Review;

public class RecipeReviewDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Review> selectCommentsByDetail(Connection conn, int no) {
		
		List<Review> comments = new ArrayList<Review>();
		
		String query = "select review_no, rcp_seq, user_id, review_contents, review_date from review where rcp_seq = ? order by review_no desc";
		ResultSet rset = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Review commentsDto = new Review();
				commentsDto.setReviewNo(rset.getInt("review_no"));
				commentsDto.setRcpSeq(rset.getInt("rcp_seq"));
				commentsDto.setUserId(rset.getString("user_id"));
				commentsDto.setReviewContents(rset.getString("review_contents"));
				commentsDto.setReviewDate(rset.getDate("review_date"));	
				comments.add(commentsDto);
			}

		}catch (Exception e) {
			e.printStackTrace();
			/* throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR); */
		}finally {
			template.close(rset,pstm);
		}
		return comments;
	}

	public void uploadReview(Connection conn, Review review) {
		String sql = "insert into review(review_no, rcp_seq, user_id, review_contents) values(REVIEW_SEQ.nextval,?,?,?)";
		
		PreparedStatement pstm = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, review.getRcpSeq());
			pstm.setString(2, review.getUserId());
			pstm.setString(3, review.getReviewContents());
			pstm.executeUpdate();

		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(pstm);
		}
		
	}



}
