package com.kh.recipe.common.code;

public enum Config {

	//DOMAIN("https://pclass.ga"),
	DOMAIN("http://localhost:9090"),
	COMPANY_EMAIL("pclassgyu@gmail.com"),
	STMP_AUTHENTICATION_ID("pclassgyu@gmail.com"),
	SMTP_AUTHENTICATION_PASSWORD("1q2w3e4r1!"),
	UPLOAD_PATH("C:\\CODE\\upload\\");
	
	public final String DESC;
	
	Config(String desc){
		this.DESC = desc;
	}
	
}
