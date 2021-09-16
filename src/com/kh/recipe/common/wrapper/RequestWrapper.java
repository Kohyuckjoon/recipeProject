package com.kh.recipe.common.wrapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper{
	
	private HttpServletRequest request;
	
	public RequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String url) {
		return request.getRequestDispatcher("/WEB-INF/views"+ url + ".jsp");
	}
	
	public RequestDispatcher getRequestDispatcher(String url, String prefix, String suffix) {
		return request.getRequestDispatcher(prefix+url+suffix);
	}

}
