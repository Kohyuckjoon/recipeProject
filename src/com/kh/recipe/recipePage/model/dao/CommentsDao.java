package com.kh.recipe.recipePage.model.dao;

import java.sql.Connection;
import java.util.List;

import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.recipePage.model.dto.Comments;

public class CommentsDao {
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Comments> selectCommentsByDetail(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
