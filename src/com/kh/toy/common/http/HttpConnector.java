package com.kh.toy.common.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.HandlableException;

public class HttpConnector {

	private static Gson gson = new Gson();
	
	public String get(String url) {
		
		String responseBody= "";
		try {
			HttpURLConnection conn = getConnection(url,"GET");
			responseBody = getResponseBody(conn);
		} catch (IOException e) {
			throw new HandlableException(ErrorCode.HTTP_CONNECT_ERROR,e);

		}
		return responseBody;
	}
	
	
	public String get(String url, Map<String,String> headers) {
		
		String responseBody= "";
		try {
			HttpURLConnection conn = getConnection(url,"GET");
			setHeaders(headers, conn);
			responseBody = getResponseBody(conn);
		} catch (IOException e) {
			throw new HandlableException(ErrorCode.HTTP_CONNECT_ERROR,e);

		}
		return responseBody;
	}
	
	public JsonElement getAsJson(String url, Map<String,String> headers) {
		
		JsonElement responseBody= null;
		
		try {
			HttpURLConnection conn = getConnection(url,"GET");
			setHeaders(headers, conn);
			responseBody = gson.fromJson(getResponseBody(conn),JsonElement.class);
		} catch (IOException e) {
			throw new HandlableException(ErrorCode.HTTP_CONNECT_ERROR,e);

		}
		return responseBody;
	}
	
	public JsonElement postAsJson(String url, Map<String,String> headers, String body) {
		
		JsonElement responseBody= null;
		try {
			HttpURLConnection conn = getConnection(url,"POST");
			setHeaders(headers, conn);
			setBody(body, conn);
			responseBody = gson.fromJson(getResponseBody(conn), JsonElement.class);
		} catch (IOException e) {
			throw new HandlableException(ErrorCode.HTTP_CONNECT_ERROR,e);

		}
		return responseBody;
	}
	
	public String post(String url, Map<String,String>headers, String body) {
		
		String responseBody="";
		
		try {
			HttpURLConnection conn = getConnection(url,"POST");
			setHeaders(headers,conn);
			setBody(body,conn);
			responseBody=getResponseBody(conn);
		} catch (IOException e) {
			throw new HandlableException(ErrorCode.HTTP_CONNECT_ERROR,e);
		}
		return responseBody;
	}
	
	private HttpURLConnection getConnection(String url, String method) throws IOException {
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setRequestMethod(method);
		
		//연결 시 최대 지연시간
		conn.setConnectTimeout(10000);
		//응답 받을 때 최대 대기시간
		conn.setReadTimeout(10000);
		return conn;
	}
	
	private String getResponseBody(HttpURLConnection conn) throws IOException {
		StringBuffer responseBody = new StringBuffer();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			String line = null;
			while ((line = br.readLine())!= null) {
				responseBody.append(line);
			}
		
		}
		return responseBody.toString();
	}
	
	private void setHeaders(Map<String,String> headers, HttpURLConnection conn) {
		for (String key : headers.keySet()) {
			conn.setRequestProperty(key, headers.get(key));
		}
	}
	
	private void setBody(String body, HttpURLConnection conn) throws IOException{
		//HttpURLConnection의 출력스트림 사용여부를 true
		conn.setDoOutput(true);
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()))) {
			bw.write(body);
			bw.flush();
		} 
	}
	
	public String urlEncodedForm(RequestParams params) {
		
		String res = "";
		Map<String,String> paramsMap = params.getParams();
		try {
			//name=value&name=value&name=value
			for (String key : paramsMap.keySet()) {
			res += "&" + URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(paramsMap.get(key), "UTF-8");
			}
			if(res.length()>0) {
				res=res.substring(1);
			}
			
		}catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		return res;
		}
		
		
	}
	
	
	

