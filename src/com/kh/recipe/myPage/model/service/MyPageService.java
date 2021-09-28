package com.kh.recipe.myPage.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.myPage.model.dao.MyReviewDao;
import com.kh.recipe.myPage.model.dto.Review;

public class MyPageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	private MyReviewDao myReviewDao = new MyReviewDao();

	public List<Review> selectReview(Review myReview) {
		Connection conn = template.getConnection();
		List<Review> myReviewList = null;
		
		try {
			myReviewList = myReviewDao.selectMyReviewList(conn);
		}finally {
			template.close(conn);
		}
		
		return myReviewList;
		
	}

	

	

}
