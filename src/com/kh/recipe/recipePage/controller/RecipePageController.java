package com.kh.recipe.recipePage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.recipePage.model.dto.Comments;
import com.kh.recipe.recipePage.model.dto.Recipe;
import com.kh.recipe.recipePage.model.dto.Review;
import com.kh.recipe.recipePage.model.service.RecipePageService;

@WebServlet("/recipePage/*")
public class RecipePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecipePageService recipePageService = new RecipePageService();
	
    public RecipePageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "recipePage":
			recipePage(request, response);
			break;
		case "recipePageToScrape":
			recipePageToScrape(request, response);
			break;
		default: throw new PageNotFoundException();
		}
	}
	
	private void recipePageToScrape(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rcpSeq = Integer.parseInt(request.getParameter("rcpSeq"));
		Recipe recipe = new Recipe();
		recipe.setRcpSeq(rcpSeq);
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		Recipes = recipePageService.selectRecipeByDetailToScrape(recipe);
		System.out.println(Recipes);
		request.setAttribute("Recipes", Recipes);
		request.getRequestDispatcher("/recipePage/recipePage").forward(request, response);
	}

	private void recipePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes = recipePageService.selectRecipeByDetail();
		request.setAttribute("Recipes", recipes);
		
		List<Comments> Comments = new ArrayList<Comments>();
		Comments = recipePageService.selectReplyByDetail();
		request.setAttribute("Comments", Comments);
		request.getRequestDispatcher("/recipePage/recipePage").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
