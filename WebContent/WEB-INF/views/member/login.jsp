<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%@ include file="/WEB-INF/include/head.jsp" %>

<a herf="javascript:kakaoLogin();"><img src="/resources/img/kakao_login_large_narrow.png" onclick="kakaoLogin();" style="height :60px;width:auto;"></a>
	<ul>
	<li onclick="accReg();">
      <a href="javascript:void(0)">
          <span>회원가입하기</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>

<script  src="https://code.jquery.com/jquery-3.5.0.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.0/axios.min.js"></script>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>

Kakao.init('3e85a50f7736492121915fea486aa4af');

var userData = '';
var jsonData = '';

function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        
		Kakao.API.request({//사용자 정보 저장
          url: '/v2/user/me',
          success: function (response) {
        	  
        	  
        	  //console.log(JSON.stringify(response))
        	  var userData = response;
        	  //console.log(JSON.stringify(response));
        	  jsonData = JSON.stringify(response);
        	  //kakao 로그인 후 user Data 를 가져옵니다.
        	  jsonData:{
        		  property_keys: ["properties.nickname",
        						  "properties.profile_image",
        						  "properties.thumbnail_image",
        						  "kakao_account.profile",
        						  "kakao_account.email",
        						  "kakao_account.age_range",
        						  "kakao_account.birthday",
        						  "kakao_account.gender",
        						  "REFRESH_TOKEN"
        			  ]
        	  }
        	  alert(userData.properties.nickname + "님 환영합니다.");
        	  /* console.log("properties.nickname =====>"+userData.properties.nickname);
        	  console.log("properties.profile_image_url =====>"+userData.kakao_account.profile.profile_image_url);
        	  console.log("properties.thumbnail_image_url =====>"+userData.kakao_account.profile.thumbnail_image_url);
        	  console.log("kakao_account.profile =====>"+userData.kakao_account.profile);
        	  console.log("kakao_account.email =====>"+userData.kakao_account.email);
        	  console.log("kakao_account.birthday =====>"+userData.kakao_account.birthday);
        	  console.log("kakao_account.gender =====>"+userData.kakao_account.gender);  */
        	  var userNickName = userData.properties.nickname;
        	  var userProfile_image = userData.kakao_account.profile.profile_image_url;
        	  var userProfile_thumnail_image = userData.kakao_account.profile.thumbnail_image_url;
        	  var useraccount_profile = userData.kakao_account.profile;
        	  var userEmail = userData.kakao_account.email;
        	  var user_birthday = userData.kakao_account.birthday;
        	  var user_gender = userData.kakao_account.gender;
        	  
        	  
        	  
        	  
          },
          fail: function (error) {
              console.log(error)
            },
          })
        },
        fail: function (error) {
          console.log(error)
        },
      })
   
  }
  


  
//kakao logout!
function kakaoLogout() {
	var logout = confirm("로그아웃 하시겠습니까?");
	if(logout == true){
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	alert("로그아웃 되셨습니다.");
        	
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