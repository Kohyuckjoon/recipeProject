package com.kh.recipe.dietHealth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.dietHealth.service.DietHealthService;

@WebServlet("/searchResult/*")
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
		case "searchResult":
			searchResult(request,response);
			break;

		default: throw new PageNotFoundException();
		}
	}

	private void searchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/dietHealth/searchResult").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
