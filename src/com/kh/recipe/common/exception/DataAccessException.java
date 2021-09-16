package com.kh.recipe.common.exception;

import com.kh.recipe.common.code.ErrorCode;

//예외처리가 강제되지 않는 UnCheckedException
public class DataAccessException extends HandlableException{

	private static final long serialVersionUID = 1L;

	public DataAccessException(Exception e) {
		super(ErrorCode.DATABASE_ACCESS_ERROR,e);
	}
}
