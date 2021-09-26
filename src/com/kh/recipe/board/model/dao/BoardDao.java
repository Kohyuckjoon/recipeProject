package com.kh.recipe.board.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.file.FileDTO;

public class BoardDao {

	JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertBoard(Connection conn, Board board) {
		String sql = "insert into board(no,title,userId,content) values("
				+ "BOARD_SEQ.nextval,?,?,?)";
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getUserId());
			pstm.setString(3, board.getContent());
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
	}

	public void insertFile(Connection conn, FileDTO fileDTO) {
		String sql = "insert into file_info(fl_idx,type_idx,"
				+ "origin_file_name,rename_file_name,save_path)"
				+ "values(sc_file_idx.nextval,sc_board_idx.currval,?,?,?)";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, fileDTO.getOriginFileName());
			pstm.setString(2, fileDTO.getRenameFileName());
			pstm.setString(3, fileDTO.getSavePath());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
	}

	public List<Board> selectBoardAll(Connection conn) { //전체 게시판 조회
		
		String sql = "select no,title,userId,date,viewCount"
				+ " from board";
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				board = new Board();
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setUserId(rset.getString("userId"));
				board.setDate(rset.getDate("regDate"));
				board.setViewCount(rset.getInt("viewCount"));
				list.add(board);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return list;
	}
	
public Board selectBoardDetail(Connection conn, int no) { //하나씩 조회
		
		String sql = "select no,userId,title,content,date,viewCount"
				+ " from board "
				+ " where no = ?";
		
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				board = new Board();
				board.setNo(rset.getInt("no"));
				board.setUserId(rset.getString("userId"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setDate(rset.getDate("date"));
				board.setViewCount(rset.getInt("viewCount"));
				
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return board;
	}

	public List<FileDTO> selectFileDTOs(Connection conn, int no) {
		
		String sql = "select fl_idx,type_idx,origin_file_name,rename_file_name,"
				+ " save_path,reg_date from file_info "
				+ " where type_idx=? and is_del = 0";
		
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<FileDTO> files = new ArrayList<FileDTO>();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				FileDTO file = new FileDTO();
				file.setFlIdx(rset.getString("fl_idx"));
				file.setTypeIdx(rset.getString("type_idx"));
				file.setOriginFileName(rset.getString("origin_file_name"));
				file.setRenameFileName(rset.getString("rename_file_name"));
				file.setSavePath(rset.getString("save_path"));
				file.setRegDate(rset.getDate("reg_date"));
				
				files.add(file);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return files;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
