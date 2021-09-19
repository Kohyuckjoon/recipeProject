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
	<li>
      <a href="/member/join-form">
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
<script type="text/javascript">

Kakao.init('0c512e152e989192c220235a73035b4b');
//console.log(Kakao.isInitialized()); 
/* //로그인 버튼 누르면? 회원가입페이지로
Kakao.Auth.authorize({
	redirectUri : 'http://localhost:9090/index'
});
 */

var userData = '';
var jsonData = '';
/* var walletAddress;
var totalReceived;
var Key;
var txIdArray = null;
var txId = null; */

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
        	  var userProfile_image = userData.kakao_account.profile.profile_image_url;
        	  var userProfile_thumnail_image = userData.kakao_account.profile.thumbnail_image_url;
        	  var useraccount_profile = userData.kakao_account.profile;
        	  var userEmail = userData.kakao_account.email;
        	  var user_birthday = userData.kakao_account.birthday;
        	  var user_gender = userData.kakao_account.gender;
        	  var html = '<br>' + userEmail + '<br>' + userNickName;
        	  
        	  //html +='<br><img src="' + userProfile_image + '">';
        	  //$('body').append(html);
        	  
        	  /* console.log("properties.nickname =====>"+userData.properties.nickname);
        	  console.log("properties.profile_image_url =====>"+userData.kakao_account.profile.profile_image_url);
        	  console.log("properties.thumbnail_image_url =====>"+userData.kakao_account.profile.thumbnail_image_url);
        	  console.log("kakao_account.profile =====>"+userData.kakao_account.profile);
        	  console.log("kakao_account.email =====>"+userData.kakao_account.email);
        	  console.log("kakao_account.birthday =====>"+userData.kakao_account.birthday);
        	  console.log("kakao_account.gender =====>"+userData.kakao_account.gender);  */
        	  
        	  location.href = 'http://localhost:9090/mainPage?userEmail='+userEmail+'&name='+userNickName;
        	  
        	  
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
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	alert("로그아웃 되셨습니다.");
        	location.href = 'http://localhost:9090/mainPage';
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