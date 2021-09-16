package com.kh.recipe.common.wrapper;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper{
	
	private HttpServletResponse response;

	public ResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response = response;
	}
	

}
