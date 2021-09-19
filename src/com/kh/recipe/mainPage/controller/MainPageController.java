package com.kh.recipe.mainPage.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.service.MainPageService;

@WebServlet("/mainPage")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainPageService mainPageService = new MainPageService();
	
    public MainPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recipes = request.getParameter("recipes");
		Map<String, Object> datas = mainPageService.selectRecipeByDetail(recipes);

		request.setAttribute("datas", datas);
		request.getRequestDispatcher("/mainPage").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
