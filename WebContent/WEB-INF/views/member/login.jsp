<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.tit{display:block; width:50px;}
.valid-msg{color:red; font-size:0.5vw;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/include/head.jsp" %>


<a herf="javascript:kakaoLogin();"><img src="/resources/img/kakao_login_large_narrow.png" onclick="kakaoLogin();" style="height :60px;width:auto;"></a>
	<ul>
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

Kakao.init('0c512e152e989192c220235a73035b4b'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단

var userData = '';
var jsonData = '';

function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
        	  alert("kakao login success!");
        	  var userData = response;
        	  jsonData = JSON.stringify(response);
        	  //kakao 로그인 후 user Data 를 가져옵니다.
        	  jsonData:{
        		  property_keys: ["properties.nickname",
        						  "properties.profile_image",
        						  "properties.thumnail_image",
        						  "kakao_account.profile",
        						  "kakao_account.email",
        						  "kakao_account.age_range",
        						  "kakao_account.birthday",
        						  "kakao_account.gender",
        						  "REFRESH_TOKEN"
        			  ]
        	  }
        	  console.log("properties.nickname =====>"+userData.properties.nickname);
        	  console.log("properties.profile_image =====>"+userData.properties.profile_image);
        	  console.log("properties.thumnail_image =====>"+userData.properties.thumnail_image);
        	  console.log("kakao_account.profile =====>"+userData.kakao_account.profile);
        	  console.log("kakao_account.email =====>"+userData.kakao_account.email);
        	  console.log("kakao_account.birthday =====>"+userData.kakao_account.birthday);
        	  console.log("kakao_account.gender =====>"+userData.kakao_account.gender);
        	  var userNickName = userData.properties.nickname;
        	  var userProfile_image = userData.properties.profile_image;
        	  var userProfile_thumnail_image = userData.properties.thumnail_image;
        	  var useraccount_profile = userData.kakao_account.profile;
        	  var userEmail = userData.kakao_account.email;
        	  var user_birthday = userData.kakao_account.birthday;
        	  var user_gender = userData.kakao_account.gender;
        	  axios.get("http://localhost:8093/myapp/getUserData",{
        		  	params:{
        		  		userNickName : userNickName,
        		  		userEmail: userEmail,
        		  		userProfile_image: userProfile_image,
        		  		user_birthday: user_birthday,
        		  		user_gender : user_gender, 
        		  		
        		  		
        		  		
        		  		
        		  	}
        	  })
        
        	  
        	  
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
        	alert("logout!");
        	console.log(response)
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