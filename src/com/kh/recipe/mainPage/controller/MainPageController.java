package com.kh.recipe.mainPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.mainPage.model.dto.Recipe;
import com.kh.recipe.mainPage.service.MainPageService;

@WebServlet("/mainPage/*")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainPageService mainPageService = new MainPageService();
	
    public MainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes = mainPageService.selectRecipeByDetail();
		request.setAttribute("Recipes", Recipes);
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length-1]) {
		case "1":
			mainPage(request, response);
			break;
		case "2":
			mainPage2(request, response);
			break;
		case "3":
			mainPage3(request, response);
			break;
		case "4":
			mainPage4(request, response);
			break;
		case "5":
			mainPage5(request, response);
			break;
		case "6":
			mainPage6(request, response);
			break;
		case "7":
			mainPage7(request, response);
			break;
		case "8":
			mainPage8(request, response);
			break;
		case "9":
			mainPage9(request, response);
			break;
		case "10":
			mainPage10(request, response);
			break;
		default: throw new PageNotFoundException();
		}
		 
	}
	
	private void mainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("pageNumber", 1);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
	}

	private void mainPage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("pageNumber", 2);
		request.getRequestDispatcher("/mainPage").forward(request, response);
		
	}
	
	private void mainPage3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 3);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}
	
	private void mainPage4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 4);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}
	
	private void mainPage5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 5);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}
	
	private void mainPage6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 6);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}

	private void mainPage7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 7);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}

	private void mainPage8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 8);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}

	private void mainPage9(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 9);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}

	private void mainPage10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("pageNumber", 10);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
