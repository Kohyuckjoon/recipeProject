<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="com.kh.recipe.member.model.dao.MemberDao" %>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  background: #76b852; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #76b852, #8DC26F);
  background: -moz-linear-gradient(right, #76b852, #8DC26F);
  background: -o-linear-gradient(right, #76b852, #8DC26F);
  background: linear-gradient(to left, #76b852, #8DC26F);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
</style>
</head>
<body>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

	<c:if test="${empty authentication}">
	
	<div class="login-page">
	  	<div class="form">
	  
		    <form class="login-form" action="/member/login" method="post">
			
			<input type="text" name="userId" id="userId" placeholder="ID"/>
		
			<input type="password" name="password" id="password" placeholder="password"/>
			
			<button>로그인 하기</button>
			
			<hr>
			
			<p><img src="/resources/img/kakao_login_large_narrow.png" onclick="kakaoLogin();" style="height :49px;width:270px;"></p>
		
			<p class="message">회원가입 되어있지 않으신가요? <a href="member/join-form">회원가입하기</a></p>
	
			</form>
	 	</div>
	</div>
	</c:if>
<c:if test="${not empty authentication}">
<c:redirect  url="/myPage/myPage"/>
</c:if>

<script type="text/javascript">




Kakao.init('0c512e152e989192c220235a73035b4b');

var userData = '';
var jsonData = '';

//카카오톡을 통한 로그인, 리다이렉트 구축
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        
		Kakao.API.request({//사용자 정보 저장
          url: '/v2/user/me',
          success: function (response) {
        	  var userData = response;
        	  //console.log(JSON.stringify(response));
        	  alert(userData.properties.nickname + "님 환영합니다.");
        	  
        	  jsonData = JSON.stringify(response);
        	  
        	  //kakao 로그인 후 user Data 를 가져옵니다.
        	  jsonData:{
        		  property_keys: ["id",
        			  			  "properties.nickname",
        						  "properties.profile_image",
        						  "properties.thumbnail_image",
        						  "kakao_account.access_token",
        						  "kakao_account.profile",
        						  "kakao_account.email",
        						  "kakao_account.age_range",
        						  "kakao_account.birthday",
        						  "kakao_account.gender",
        						  "REFRESH_TOKEN"
        						  
        			  ]
        	  }  
        	  
        	  
        	  
        	  var userId = userData.id;
        	  var userNickName = userData.properties.nickname;
        	  var userEmail = userData.kakao_account.email;
        	  //var user_birthday = userData.kakao_account.birthday;
        	  //var user_gender = userData.kakao_account.gender;
        	  //var html = '<br>' + userEmail + '<br>' + userNickName;
        	  
        	  //html +='<br><img src="' + userProfile_image + '">';
        	  //$('body').append(html);
        	  
        	  /* console.log("properties.nickname =====>"+userData.properties.nickname);
        	  console.log("properties.profile_image_url =====>"+userData.kakao_account.profile.profile_image_url);
        	  console.log("properties.thumbnail_image_url =====>"+userData.kakao_account.profile.thumbnail_image_url);
        	  console.log("kakao_account.profile =====>"+userData.kakao_account.profile);
        	  console.log("kakao_account.email =====>"+userData.kakao_account.email);
        	  console.log("kakao_account.birthday =====>"+userData.kakao_account.birthday);
        	  console.log("kakao_account.gender =====>"+userData.kakao_account.gender);  */
        	  
        	  location.href = 'http://localhost:9090/mainPage/mainPage?userEmail='+userEmail+'&name='+userNickName;
        	  
        	  
          },
          fail: function (error) {
        	  alert("카카오 로그인이 취소되었습니다.");
            },
          })
          
          console.log(response);
		  var token = response.access_token;
		  
        },
        fail: function (error) {
          console.log(error)
        },
      });
   
	

}

  
//kakao logout!
function kakaoLogout() {
	 if (!Kakao.Auth.getAccessToken()) {
	      alert("로그인 되어있지 않습니다.");
	      return
	    }
	var logout = confirm("로그아웃 하시겠습니까?");
	if(logout == true){
		Kakao.Auth.logout(function() {
       	alert("로그아웃 되셨습니다.");
       	Kakao.Auth.getAccessToken()
        location.href = 'http://localhost:9090/mainPage/mainPage';
      })
      Kakao.Auth.setAccessToken(undefined)
	}else{
		return false;
		
	}
  }  

//회원탈퇴
function unlinkApp() {
	 if (!Kakao.Auth.getAccessToken()) {
	      alert("로그인 되어있지 않습니다.");
	      return
	    }
	var logout = confirm("회원탈퇴 하시겠습니까?");
	if(logout == true){
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	alert("회원탈퇴 되셨습니다.");
        	location.href = 'http://localhost:9090/mainPage/mainPage';
        },
        fail: function (error) {
          console.log(error)
        },
        
      })
      Kakao.Auth.setAccessToken(undefined)
      
    }
	}else{
		return false;
		
	}
  }  

</script>	  

 
	
	
	

	





  
  
  
  
 
 
</body>
</html>



