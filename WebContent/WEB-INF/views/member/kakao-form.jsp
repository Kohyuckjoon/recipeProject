<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%@ include file="/WEB-INF/include/head.jsp" %>

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
    
	 if (isset($_GET['code'])) {

         require_once realpath(dirname(__FILE__).'/../libraries/SNS_OAuth/').'/kakao_oauth.php';

         $url = "https://kauth.kakao.com/oauth/token";
         
         $param = "grant_type=authorization_code";
         $param .= "&client_id=".$kakao_api;
         $param .= "&redirect_url=".$kakao_redirect;
         $param .= "&code=".$_GET['code'];

         // Get Aeccess Token Value
         
         $auth_data = $this->common->restful_curl($url, $param, 'POST');
         $auth_data = json_decode($auth_data);

        
         
         if($auth_data->access_token) {
            
             $_SESSION['kakao_token'] = $auth_data->access_token;
             
             $url = "https://kapi.kakao.com/v1/user/me";
             $param = "";
             $header = array("Authorization: Bearer " .$auth_data->access_token);


             // Get User Info
             $user_data = $this->common->restful_curl($url, $param, 'POST', $header);
             $user_data = json_decode($user_data);

             $nickname=isset($user_data->name)?$user_data->name :"";
             $thumbnail_image=isset($user_data->thumbnail_image)?$user_data->thumbnail_image:"";
             
             // Add Code :: Valid Member
             $assign_data=array(
                 'sns_id'=>$user_data->id,
                 'sns_type'=>'kakao',
                 'profile_img'=>$thumbnail_image,
                 'email'=>$user_data->kaccount_email,
                 'name'=>$user_data->name,
                 'nickname'=>''   
             );
             
             $this->_register_action($assign_data);

         }else {
             $this->script->alert("Kakao Token Access Fail.");
             $this->script->locationhref('/index.php/auth');
         }

     }else {
         $this->script->alert("Invailed Access.");
         $this->script->locationhref('/index.php/auth');
     } 
	
	
	/* Kakao.Auth.login({
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
        	  //var userProfile_image = userData.kakao_account.profile.profile_image_url;
        	  //var userProfile_thumnail_image = userData.kakao_account.profile.thumbnail_image_url;
        	  //var useraccount_profile = userData.kakao_account.profile;
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
   
      */

}

      function _register_action($assign_data) {

          //sns 의경우 이메일이 없는 경우가 있으므로 없을 경우 sns_id 값으로 저장
         $insertId=$assign_data['email']!=null ? $assign_data['email'] :$assign_data['sns_id'];
         
         //sns_id 로 기존에 등록된 유저 확인
         $sql="select * from users where userid=?";
         $query=$this->db->query($sql,  $insertId);
         
        
         $message="";
         //등록된 userid 를 확인 한다.
         if($query->num_rows() > 0){
             //테스트 메시지
             $message="userid 가 존재";
         }
         else
         {
             //userid 값이 없으면 등록한다. 
              // Member Register in Your Code.       
              $data=array(
                 'userid' =>$insertId,
                 'sns_id'=>$assign_data['sns_id'],
                 'sns_type'=>$assign_data['sns_type'],
                 'register_auth_code'=>1,  //이메일 인증 코드 1로 
                 'profile_img'=>$assign_data['profile_img'],
                 'email'=>$assign_data['email'],
                 'nickname'=>$assign_data['nickname'],
                 'username'=>$assign_data['name'],
                 'register_ip'=>$_SERVER['REMOTE_ADDR']
                 );       
             $this->db->insert('users', $data);
               $message="등록했습니다.";
                       
         }
         
         //DB에서 정보를 다시 불러온다.
         $sql="select * from users where userid=?";
         $query=$this->db->query($sql,  $insertId);
         $result=$query->row();

          //세션 생성         
         if($result) {             
             //세션 생성         
             $newdata =array(
                 'nickname' =>$result->nickname,
                 'email' =>$result->email,
                 'logged_in' =>TRUE,
                 'auth_code' =>$result->auth_code,
                 'icon'=>$result->icon,
                 'sns_type'=>$result->sns_type,
                 'userid' =>$result->userid
             );
             
             $this->session->set_userdata($newdata);
             
             redirect('/');
             exit;
          }else{
              
              alert('로그인에 실패 하였습니다.', '/');
              exit;
          }                            
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
        location.href = 'http://localhost:9090/mainPage';
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