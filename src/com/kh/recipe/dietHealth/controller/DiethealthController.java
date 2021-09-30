package com.kh.recipe.dietHealth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.dietHealth.service.DietHealthService;

@WebServlet("/dietHealth/searchResult/*")
public class DiethealthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DietHealthService dietHealthService = new DietHealthService();
       
    public DiethealthController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		
		switch (uriArr[uriArr.length-1]) {
		case "searchResult": //검색결과
			searchResult(request,response);
			break;
			
		case "checkBox": //체크박스
			checkBox(request,response);
			break;
			
		case "clickedPage":
			clickedPage(request, response);
			break;
			
		default: throw new PageNotFoundException();
		}
		
	}
	
	private void clickedPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/mainPage").forward(request, response);
		
	}

	private void checkBox(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void searchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//체크박스 입력을 받아서,
		//필요한 칼로리, 나트륨, 지방, 단백질을 입력 받아서
		//sql 디벨로퍼에 있는 정보중에 부합하는것들을 가져와야함
		
		
		request.getRequestDispatcher("/dietHealth/searchResult").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
