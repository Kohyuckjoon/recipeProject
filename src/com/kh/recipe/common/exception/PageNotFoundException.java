package com.kh.recipe.common.exception;

public class PageNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public PageNotFoundException() {
		//stackTrace를 비워준다.
		this.setStackTrace(new StackTraceElement[0]);
	}
	
}
