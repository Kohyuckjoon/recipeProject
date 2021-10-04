<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
window.onload = function kakaoLogin() {
	Kakao.init('0c512e152e989192c220235a73035b4b');
	Kakao.isInitialized();
	var userData = '';
	var jsonData = '';
    Kakao.Auth.login({
      success: function (response) {
        
		Kakao.API.request({//사용자 정보 저장
          url: '/v2/user/me',
          success: function (response) {
        	  var userData = response;
        	  console.dir(userData);
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
        	  //var userProfile_image = userData.kakao_account.profile.profile_image_url;
        	  //var userProfile_thumnail_image = userData.kakao_account.profile.thumbnail_image_url;
        	  //var useraccount_profile = userData.kakao_account.profile;
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
        	  sessionStorage.setItem("userId", userId);
        	  sessionStorage.setItem("userNickName", userNickName);
        	  sessionStorage.setItem("userEmail", userEmail);
        	  
        	  var kakaoSession = sessionStorage.getItem(userId, userNickName, userEmail);
        	  
			  //document.querySelector("#result").innerHTML = kakaoSession;
			  location.href = 'http://localhost:9090/mainPage/mainPage?userEmail='+userEmail+'&name='+userNickName;
        	  
        	  
          },
          fail: function (error) {
        	  alert("카카오 로그인이 취소되었습니다.");
            },
          })
          
          console.log(response);
		  console.log(response.access_token);
		  var token = response.access_token;
		  
        },
        fail: function (error) {
          console.log(error)
        },
      });
   
	

}
</script>


</body>
</html>