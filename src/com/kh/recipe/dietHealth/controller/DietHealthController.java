package com.kh.recipe.dietHealth.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.recipe.common.exception.PageNotFoundException;
import com.kh.recipe.dietHealth.model.dto.DietHealth;

@WebServlet("/dietHealth/*")
public class DietHealthController extends HttpServlet {
	
	/**
	 * ESSENTIAL STATIC VARIABLE
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isDebug = false;
	
	private final String MAIN = "main";
//	private final String SEARCH_RESULT = "searchResult";

	public DietHealthController() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(isDebug) {
			System.out.println(req.getRequestURL());
			System.out.println(subURLParser(req.getRequestURL().toString()));
		}
		switch(subURLParser(req.getRequestURL().toString())) {
			case MAIN : 
				req.getRequestDispatcher("/dietHealth/main").forward(req, resp);
				break;
//			case SEARCH_RESULT : 
//				break;
			default :
				throw new PageNotFoundException();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private String subURLParser(String origin) {
		return origin.substring(origin.lastIndexOf("/") + 1);
	}
	
}
