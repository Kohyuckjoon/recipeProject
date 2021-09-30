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

import oracle.jdbc.OracleConnection.CommitOption;

public class BoardDao {

	JDBCTemplate template = JDBCTemplate.getInstance();
	
	public void insertBoard(Connection conn, Board board) {
		String sql = "insert into board(no,title,user_id,content) values("
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
				+ "values(SC_FILE_IDX.nextval,BOARD_SEQ.currval,?,?,?)";
		
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

	
public Board selectBoardDetail(Connection conn, int no) { //하나씩 조회
	
	
	String sql = "select no,user_id,title,content,reg_date,view_count"
				+ " from board "
				+ " where no = ?";
		
		PreparedStatement pstm = null;
		ResultSet rset = null;
		updateViewCount(conn, no);
		Board board = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				board = new Board();
				board.setNo(rset.getInt("no"));
				board.setUserId(rset.getString("user_id"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setViewCount(rset.getInt("view_count"));
				
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


	//조회수 증가  viewCount  Dao 단
	
		public int updateViewCount(Connection conn, int no) {
			
			String sql = "update board set view_count = view_count + 1 where no =? ";
			PreparedStatement pstm = null;
			ResultSet rset = null;
			int cnt = 0;
			try {
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, no);
				cnt = pstm.executeUpdate();
				
				
			} catch (SQLException e) {
				throw new DataAccessException(e);
			}finally {
				
				template.close(rset,pstm);
			}
			 return no;
		}
		
		
	public Board updateBoard(Connection conn, int no) {
		String sql = "update board set title = ?, content = ?"
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
				
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setUserId(rset.getString("user_id"));
				
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return board;
	
	}

	public List<FileDTO> updateFileDTOs(Connection conn, int no) {
		String sql = "update file_info set type_idx,origin_file_name,rename_file_name,save_path "
				+ " where fl_idx=?";
		
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<FileDTO> files = new ArrayList<FileDTO>();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				FileDTO file = new FileDTO();
				file.setTypeIdx(rset.getString("type_idx"));
				file.setOriginFileName(rset.getString("origin_file_name"));
				file.setRenameFileName(rset.getString("rename_file_name"));
				file.setSavePath(rset.getString("save_path"));
				
				
				files.add(file);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		
		return files;
	}

	public List<Board> selectBoardAll(Connection conn) {
		String sql = "select no,title,user_id,reg_date,view_count"
				+ " from board order by no desc";
		
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Board board = new Board();
				
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setUserId(rset.getString("user_id"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setViewCount(rset.getInt("view_count"));
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return boardList;
		
	}

	public Board deleteBoard(Connection conn, int no) {
		String sql = "delete from board where no ?";
		
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();
			
		int flag = pstm.executeUpdate();
		if(flag > 0) {
			
			conn.commit();
		}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return board;
	
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
