package com.kh.recipe.recipePage.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.recipePage.model.dao.ReviewDao;
import com.kh.recipe.recipePage.model.dto.Review;

public class RecipePageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	private ReviewDao reviewDao = new ReviewDao();
	
	public List<Review> selectReview(int rcpSeq) { 
		
		Connection conn = template.getConnection();
		
		List<Review> reviewList = new ArrayList<Review>();
		
		try {
			reviewList = reviewDao.selectReview(conn,rcpSeq);
		} finally {
			template.close(conn);
		}
		
		return reviewList;
	}

}
