package com.kh.recipe.board.model.service;

import java.sql.Connection;
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
	
	public void insertBoard(Board board, List<FileDTO> files) {
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

	public Map<String, Object> selectBoardDetail(int no) {
		
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

}