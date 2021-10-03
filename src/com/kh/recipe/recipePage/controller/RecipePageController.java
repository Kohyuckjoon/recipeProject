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
import com.kh.recipe.recipePage.model.dto.Review;
import com.kh.recipe.recipePage.model.service.RecipePageService;

@WebServlet("/recipePage/*")
public class RecipePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecipePageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "recipePage":
			recipePage(request, response);
			break;
		default: throw new PageNotFoundException();
		}
	}
	
	private void recipePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/recipePage/recipePage").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
