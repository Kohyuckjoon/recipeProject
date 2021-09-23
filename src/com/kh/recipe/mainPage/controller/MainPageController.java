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
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length-1]) {
		case "1":
			mainPage(request, response);
			break;
		case "2":
			mainPage2(request, response);
			break;
		default: throw new PageNotFoundException();
		}
		

	}


	private void mainPage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes = mainPageService.selectRecipeByDetail();
		request.setAttribute("Recipes", Recipes);
		request.setAttribute("pageNumber", 2);
		request.getRequestDispatcher("/mainPage").forward(request, response);	
	}

	private void mainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes = mainPageService.selectRecipeByDetail();
		request.setAttribute("Recipes", Recipes);
		request.setAttribute("pageNumber", 1);
		request.getRequestDispatcher("/mainPage").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
