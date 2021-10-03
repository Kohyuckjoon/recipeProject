package com.kh.recipe.dietHealth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.dietHealth.service.DietHealthService;
import com.kh.recipe.mainPage.model.dto.Recipe;


@WebServlet("/dietHealth/*")
public class DietHealthController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DietHealthService dietHealthService = new DietHealthService();
	
	public DietHealthController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes = dietHealthService.selectSearchResult();
		request.setAttribute("Recipes", Recipes);
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length-1]) {
		case "main":
			main(request, response);
			break;
		case "clickedPage":
			clickedPage(request, response);
			break;
		default: throw new PageNotFoundException();
		}
		 
	}

	private void clickedPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/dietHealth/main").forward(request, response);			
	}

	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/dietHealth/main").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
