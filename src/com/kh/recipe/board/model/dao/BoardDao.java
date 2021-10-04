package com.kh.recipe.board.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.board.model.dto.Comments;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.file.FileDTO;

import oracle.jdbc.OracleConnection.CommitOption;

public class BoardDao {

	JDBCTemplate template = JDBCTemplate.getInstance();

	// 게시물 작성
	public void insertBoard(Connection conn, Board board) {
		String sql = "insert into board(no,title,user_id,content) values(" + "BOARD_SEQ.nextval,?,?,?)";

		PreparedStatement pstm = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getUserId());
			pstm.setString(3, board.getContent());
			pstm.executeUpdate();

		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(pstm);
		}
	}

	

	// 게시글 하나씩 조회
	public Board selectBoardDetail(Connection conn, int no) { // 하나씩 조회

		String sql = "select no,user_id,title,content,reg_date,view_count from board "
				+ " where no = ?";
		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeQuery();

			while (rset.next()) {
				board = new Board();
				board.setNo(rset.getInt("no"));
				board.setUserId(rset.getString("user_id"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setViewCount(rset.getInt("view_count"));

			}

		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(rset, pstm);
		}
		return board;
	}

	

	// 조회수 증가 viewCount Dao 단

	public int updateViewCount(Connection conn, int no) {
		String sql = "update board set view_count = view_count+1 where no = ? ";
		PreparedStatement pstm = null;
		int rset = 0;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			rset = pstm.executeUpdate();
			template.commit(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			template.close(pstm);
		}
		
		
		return rset;
	}

	// 게시글 수정
	public int updateBoard(Connection conn, String title, String content, int no) {
		String sql = "update board set title = ? , content = ?  where no = ?";

		PreparedStatement pstm = null;
		int rset = 0;
	
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,title);
			pstm.setString(2, content);
			pstm.setInt(3, no);
			rset = pstm.executeUpdate();
			
			template.commit(conn);

			
			
		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(pstm);
		}
		return rset;

	}

	

	// 리스트로 전체 게시글 목록
	public List<Board> selectBoardAll(Connection conn,Board board) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String sql = "  select  no , user_id, title, reg_date, view_count" + 
				" from (select rownum as rnum,  no , user_id, title, reg_date, view_count "  + 
				" from board  order by no desc)" +
				"  where rnum between  ? and ?";

		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, board.getStartIdx());
			pstm.setInt(2, board.getRowCntPage());
			rset = pstm.executeQuery();

			while (rset.next()) {
				board = new Board();
				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setUserId(rset.getString("user_id"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setViewCount(rset.getInt("view_count"));
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(rset, pstm);
		}
		return boardList;

	}

	

	//게시글 삭제 구문
	public int deleteBoard(Connection conn, int no) {
		
		int result = 0;
		//System.out.println("게시글 번호 : " + no);
		String sql = "delete from board where no =?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, no);
			result = pstm.executeUpdate();
			template.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			template.close(pstm);
		}
		
		
		return result;
	}



	public List<Board> selectBoard(int category, String keyword, Connection conn) {
		
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String sql = null;

		try {
			if(category == 1) {
				sql ="select no,title,user_id,reg_date,view_count from board where user_id like ? "+"order by no desc" ;
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + keyword +"%");
			}else if(category == 2) {
				sql = "select no,title,user_id,reg_date,view_count from board where title like ? " + " order by no desc";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + keyword +"%");
			}else if(category == 3) {
				sql = "select no,title,user_id,reg_date,view_count from board where user_id like ? or content like ? "+" order by no desc" ;
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, "%" + keyword +"%");
				pstm.setString(2, "%" + keyword +"%");
			}
			
			rset = pstm.executeQuery();

			while (rset.next()) {

				Board board = new Board();

				board.setNo(rset.getInt("no"));
				board.setTitle(rset.getString("title"));
				board.setUserId(rset.getString("user_id"));
				board.setRegDate(rset.getDate("reg_date"));
				board.setViewCount(rset.getInt("view_count"));
				list.add(board);
			}

		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(rset, pstm);
		}
		

		return null;
	}



	public void insertComment(Connection conn, Comments comment) {
		String sql = "insert into comments(comment_no,comment_content,user_id) values(" + "comment_seq.nextval,?,?)";

		PreparedStatement pstm = null;

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, comment.getCommentContent());
			pstm.setString(2, comment.getUserId());
			pstm.executeUpdate();

		} catch (SQLException e) {
			/* throw new DataAccessException(e); */
			e.printStackTrace();
		} finally {
			template.close(pstm);
		}
	}


	
	public int selPageLength(Connection conn,Board board,int page) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int res = 0;
		String sql = "select ceil(count(no)/?) from board";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, board.getRowCntPage()/page); 
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

	}



	


