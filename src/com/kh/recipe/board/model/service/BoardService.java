package com.kh.recipe.board.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.kh.recipe.board.model.dao.BoardDao;
import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.file.FileDTO;

public class BoardService {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	private BoardDao boardDao = new BoardDao();
	
	public void insertBoard(Board board, List<FileDTO> files) { //게시글 작성 폼
		Connection conn = template.getConnection();
		
		try {
			boardDao.insertBoard(conn, board);
			for (FileDTO fileDTO : files) {
				boardDao.insertFile(conn,fileDTO);
			}
			template.commit(conn);
		} catch (DataAccessException e) {
			template.rollback(conn);
			throw e;
		}finally {
			template.close(conn);
		}
	}

	public Map<String, Object> selectBoardDetail(int no) { //게시글 하나씩
		
		Connection conn = template.getConnection();
		Map<String,Object> res = new HashMap<String, Object>();
		
		try {
			Board board = boardDao.selectBoardDetail(conn,no);
			List<FileDTO> files = boardDao.selectFileDTOs(conn,no);
			res.put("board", board);
			res.put("files", files);
		} finally {
			template.close(conn);
		}
		
		return res;
	}
	
	

	public Map<String, Object> updateBoard(int no) { //수정
		Connection conn = template.getConnection();
		Map<String,Object> res = new HashMap<String, Object>();
		
		try {
			Board board = boardDao.updateBoard(conn,no);
			List<FileDTO> files = boardDao.updateFileDTOs(conn,no);
			res.put("board", board);
			res.put("files", files);
		} finally {
			template.close(conn);
		}
		
		return res;
	}

	public List<Board> selectBoardAll() { //게시글 목록 페이지 
		Connection conn = template.getConnection();
		List<Board> boardList = new ArrayList<Board>();
		try {
			
		 boardList = boardDao.selectBoardAll(conn);
		
		} finally {
			template.close(conn);
		}
		
		return boardList;
	}



	/*
	 * public int deleteBoard(int no) { Connection conn =template.getConnection();
	 * int deleteNum = 0; deleteNum = boardDao.deleteBoard(conn,no); return
	 * deleteNum;
	 * 
	 * }
	 */

	public void updateViewCount(int no) {
		// TODO Auto-generated method stub
		Connection conn = template.getConnection();
	}

	public List<Board> search(String searchoption, String searchkeyword) {
		Connection conn = template.getConnection();
		List<Board> list = new ArrayList<Board>();
		try {
			
		 list = boardDao.search(conn,searchoption,searchkeyword);
		
		} finally {
			template.close(conn);
		}
		
		return list;
	} 

	

}