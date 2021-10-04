package com.kh.recipe.dietHealth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.board.model.dto.Board;
import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.dietHealth.model.dto.DietHealth;
import com.kh.recipe.dietHealth.service.DietHealthService;
import com.kh.recipe.mainPage.model.dto.Recipe;

@WebServlet("/dietHealth/*")
public class DietHealthController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DietHealthService dietHealthService = new DietHealthService();
	
	public DietHealthController() {
        super();
    }

	private String checked_value(String num) {
		if (num == null) {
			return null;
		}
		switch(num) {
		case "50":
			return "between 0 and 50";
		case "100":
			return "between 50 and 100";
		case "150":
			return "between 100 and 150";
		case "300":
			return "between 0 and 300";
		case "500":
			return "between 300 and 500";
		case "700":
			return "between 500 and 700";
		default:
			return null;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//

		String check_value = "";
		if (null != checked_value(request.getParameter("calorie"))){
			check_value += "and INFO_ENG " + checked_value(request.getParameter("calorie"))+" ";
		}
		if(null != checked_value(request.getParameter("salt"))){
			check_value += "and INFO_NA " + checked_value(request.getParameter("salt"))+" ";
		}
		if(null != checked_value(request.getParameter("fat"))){
			check_value += "and INFO_FAT " + checked_value(request.getParameter("fat"))+" ";
		}
		if(null != checked_value(request.getParameter("protein"))){
			check_value += "and INFO_PRO " + checked_value(request.getParameter("protein"))+" ";
		}
		System.out.println(check_value);

		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes = dietHealthService.selectSearchResult(check_value);
		request.setAttribute("Recipes", Recipes);

		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length-1]) {
		case "main":
			main(request, response);
			break;
		case "clickedPage":
			clickedPage(request, response);
			break;

		case "checkBox":
			System.out.println();

//			checkBoxPage(request, response);
			break;

		default: throw new PageNotFoundException();
		}

	}

	private void checkBoxPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/dietHealth/main").forward(request, response);
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



