package com.kh.recipe.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.board.model.dao.BoardDao;
import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.board.model.dto.Comments;
import com.kh.recipe.board.model.service.BoardService;
import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.common.file.FileDTO;
import com.kh.recipe.common.file.FileUtil;
import com.kh.recipe.common.file.MultiPartParams;
import com.kh.recipe.member.model.dto.Member;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] uriArr = request.getRequestURI().split("/");

		switch (uriArr[uriArr.length - 1]) {
		case "board-form":
			boardForm(request, response);
			break;
		case "board-list":
			boardList(request, response);
			break;
		case "upload":
			upload(request, response);
			break;
		case "updateUpload":
			//updateUpload(request, response);
			break;
		case "board-detail":
			boardDetail(request, response);
			break;

		case "board-update":
			//boardUpdate(request, response);
			break;

		case "board-delete":
			 boardDelete(request,response);
			break;
		case "comment":
			 comment(request,response);
			break;	
		

		default:
			throw new PageNotFoundException();

		}
	}
private void comment(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
	Member member = (Member) request.getSession().getAttribute("authentication");

	FileUtil util = new FileUtil();
	MultiPartParams multiPart = util.fileUpload(request);

	Comments comment = new Comments();
	comment.setUserId(member.getUserId());
	comment.setCommentContent(multiPart.getParameter("commentContent"));
	
	boardService.insertComment(comment);
	response.sendRedirect("/board/board-detail");
	}

/*
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int category = Integer.parseInt(request.getParameter("searchCategory"));
		String keyword = request.getParameter("searchKeyword");
		
		System.out.println("category ="+category);
		System.out.println("keyword ="+keyword);
		List<Board> list = boardService.select(category,keyword);
		request.setAttribute("boardList", list);
		request.getRequestDispatcher("/board/board-list").forward(request, response);
	}*/

	// 게시물 삭제

	private void boardDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		int result = boardService.deleteBoard(no);
		
	 response.sendRedirect("/board/board-list"); 

	}

	// 게시물 수정
	
	private void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			
			
			/* int no = Integer.parseInt(request.getParameter("no")); String title =
			 * request.getParameter("title"); String content =
			 * request.getParameter("content"); int result = boardService.updateBoard(title,
			 * content);
			 * 
			 * request.getRequestDispatcher("/board/board-update").forward(request,
			 * response);*/
			/*
			 * int no = Integer.parseInt(request.getParameter("no")); String title =
			 * request.getParameter("title"); String content =
			 * request.getParameter("content");
			 * 
			 * BoardService boardService = new BoardService(); Board board = new Board();
			 * board.setTitle(title); board.setContent(content);
			 * boardService.updateBoard(title, content);
			 * response.sendRedirect("/board/board-detail");
			 */
		
		int no = Integer.parseInt(request.getParameter("no"));
		boardService.selectBoardDetail(no);
		request.setAttribute("board", no);
		request.getRequestDispatcher("/board/board-update").forward(request, response);
	  }
	 
	// 게시물 목록
	private void boardList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		 
		Board board = new Board();
		board.setNo(board.getNo());
		List<Board> datas = boardService.selectBoardAll();
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("/board/board-list").forward(request, response);
		
		int category = Integer.parseInt(request.getParameter("searchCategory"));
		String keyword = request.getParameter("searchKeyword");
		
		if(keyword != null) {
			datas  = boardService.select(category,keyword);
			request.setAttribute("datas", datas );
			request.getRequestDispatcher("/board/board-list").forward(request, response);	
			return;
		}
		
	}

	// 게시물 상세글
	private void boardDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 게시글 상세페이지, 해당 게시글의 bdIdx를 요청파리미터에서 받아온다.
		int no = Integer.parseInt(request.getParameter("no"));

		// boardService에서 게시글 상세페지에 뿌려주기 위한 데이터(게시글 정보, 파일정보)를 받아온다.
		boardService.updateViewCount(no);
		Map<String, Object> datas = boardService.selectBoardDetail(no);
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("/board/board-detail").forward(request, response);
	}

	// 게시글 수정 업로드
	private void updateUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("authentication");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int no = Integer.parseInt(request.getParameter("no"));
		
		int result = boardService.updateBoard(title, content, no);
		if(result != 0 ) {
			response.sendRedirect("/board/board-detail");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('이메일이 변경되지 않았습니다. 아이디, 비밀번호를 확인해주세요'); location.href='/myPage/memberInfo#tab2'</script>");
			 
			out.flush();
		}

		
	}

	// 게시글 업로드
	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member) request.getSession().getAttribute("authentication");

		FileUtil util = new FileUtil();
		MultiPartParams multiPart = util.fileUpload(request);

		Board board = new Board();
		board.setUserId(member.getUserId());
		board.setTitle(multiPart.getParameter("title"));
		board.setContent(multiPart.getParameter("content"));
		
		boardService.insertBoard(board);
		response.sendRedirect("/board/board-list"); // 게시판 글 쓰고 성공하면 인덱스 페이지였음 -> 나는 성공하면 게시판 리스트로 전송
	
		
		

	}

	private void boardForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/board/board-form").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
