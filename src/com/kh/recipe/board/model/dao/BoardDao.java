package com.kh.recipe.board.model.dao;

import java.sql.Connection;
import java.util.List;

import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.common.file.FileDTO;

public class BoardDao {

	public void insertBoard(Connection conn, Board board) {
		// TODO Auto-generated method stub
		
	}

	public void insertFile(Connection conn, FileDTO fileDTO) {
		// TODO Auto-generated method stub
		
	}

	public Board selectBoardDetail(Connection conn, String bdIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FileDTO> selectFileDTOs(Connection conn, String bdIdx) {
		// TODO Auto-generated method stub
		return null;
	}

}
