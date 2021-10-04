package com.kh.recipe.board.model.service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.kh.recipe.board.model.dao.BoardDao;
import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.board.model.dto.Comments;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.DataAccessException;
import com.kh.recipe.common.file.FileDTO;

public class BoardService {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	private BoardDao boardDao = new BoardDao();
	
	public void insertBoard(Board board) { //게시글 작성 폼
		Connection conn = template.getConnection();
		
		try {
			boardDao.insertBoard(conn, board);
			
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
			
			res.put("board", board);
			
		} finally {
			template.close(conn);
		}
		
		return res;
	}
	
	


	public List<Board> selectBoardAll(Board board) { //게시글 목록 페이지 
		Connection conn = template.getConnection();
		List<Board> boardList = new ArrayList<Board>();
		try {
			
		 boardList = boardDao.selectBoardAll(conn,board);
	
		} finally {
			template.close(conn);
		}
		
		return boardList;
	}



	
	  public int deleteBoard(int no) { 
		  int res = 0;
		  Connection conn =template.getConnection();
		   
		  try {
			  res = boardDao.deleteBoard(conn,no);
			
		  }catch (Exception e) {
			  e.printStackTrace();
		  }finally { 
			  template.close(conn); 
		  } 
		  
		  return res;
			  
	  }
	 

	
	  public int updateViewCount(int no) { // TODO Auto-generated method stub
		  Connection conn = template.getConnection(); 
		  int res = 0;
		  
		  try {
			  res = boardDao.updateViewCount(conn,no);
			
		  }catch (Exception e) {
			  e.printStackTrace();
		  }finally { 
			  template.close(conn); 
		  } 
		  
		  return res;
			  
	  }
	 

		public int updateBoard(String title,String content,String no) { //수정
			  Connection conn = template.getConnection(); 
			  int res = 0;
			  
			  try {
				  res = boardDao.updateBoard(conn,title,content,no);
				  
			  }catch (Exception e) {
				  e.printStackTrace();
			  }finally { 
				  template.close(conn); 
			  } 
			  System.out.println(res);
			  return res;
		}
	

	public List<Board> select(int category, String keyword) {
		Connection conn = template.getConnection();
		List<Board> list = new ArrayList<>();
		try {
			
			list = boardDao.selectBoard(category,keyword,conn);
			
			} finally {
				template.close(conn);
			}
			
			return list;
	}

	public void insertComment(Comments comment) {
		Connection conn = template.getConnection();
		
		try {
			boardDao.insertComment(conn, comment);
			
			template.commit(conn);
		} catch (DataAccessException e) {
			template.rollback(conn);
			throw e;
		}finally {
			template.close(conn);
		}
	}

	public  int selPageLength(Board board ,int page) {
		int res = 0;
		Connection conn = template.getConnection();
		
		try {
			res=boardDao.selPageLength(conn,board,page);
			
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}finally {
			template.close(conn);
		}
		return res;
	}

	

}