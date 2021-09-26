package com.kh.recipe.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.board.model.dto.Board;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch (uriArr[uriArr.length-1]) {
		case "board-form":
			boardForm(request,response);
			break;
		case "board-list":
			boardList(request,response);
			break;
		case "upload":
			upload(request,response);
			break;
		case "board-detail":
			boardDetail(request,response);
			break;
		default:throw new PageNotFoundException();
		
		}
	}

	private void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/board/board-list").forward(request, response);
	}

	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//게시글 상세페이지, 해당 게시글의 bdIdx를 요청파리미터에서 받아온다.
		int no = Integer.parseInt(request.getParameter("no"));
		
		//boardService에서 게시글 상세페지에 뿌려주기 위한 데이터(게시글 정보, 파일정보)를 받아온다.
		Map<String, Object> datas = boardService.selectBoardDetail(no);
		
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("/board/board-detail").forward(request, response);
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		FileUtil util = new FileUtil();
		MultiPartParams multiPart = util.fileUpload(request);
		Member member  =(Member) request.getSession().getAttribute("authentication");
		
		Board board = new Board();
		board.setUserId(member.getUserId());
		board.setTitle(multiPart.getParameter("title"));
		board.setContent(multiPart.getParameter("content"));
		
		List<FileDTO> files = multiPart.getFilesInfo();
		boardService.insertBoard(board,files);
		
		response.sendRedirect("/");
	}

	private void boardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/board/board-form").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
