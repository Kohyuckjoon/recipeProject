package com.kh.recipe.common.http;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestParams {

	private Map<String,String> params = new HashMap<String,String>();
	
	private RequestParams(RequestParamsBuilder builder) {
		this.params = builder.params;
	}
	
	public static RequestParamsBuilder builder() {
		return new RequestParamsBuilder();
	}
	
	
	public static class RequestParamsBuilder {
		
		private Map<String,String> params = new LinkedHashMap<String, String>();
		
		public RequestParamsBuilder param(String name, String value) {
			params.put(name, value);
			return this;
		}
		
		public RequestParams build() {
			return new RequestParams(this);
		}
	}

	public Map<String, String> getParams() {
		return params;
	}
	
	
	
	
	
}
