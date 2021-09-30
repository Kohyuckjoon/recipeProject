/* 
	1. 이미 존재하는 아이디로 사용자가 가입하려는 경우 
	2. 비밀번호는 영어, 숫자, 특수문자 조합의 8자리 이상의 문자열
	3. 전화번호는 숫자로만 입력 */
	(()=>{
		let confirmId = '';
   		document.querySelector("#btnKakaoLogin").addEventListener('click', e => {

   			//id속성값이 지정되어있으면 id값으로 해당 요소객체 호출 가능
   			let id = userId.value;
   			
   			if(id){
   				fetch('/member/kakao-login?userId=' + id)
   				.then(response => {
					if(!response.ok) throw new Error(`${response.statusText} : ${response.status}`);
					return response.text();
					}).then(text => {
					if(text == 'available'){
   						alert(userId+"님 환영합니다.");			
   					}else if(text == 'disable'){
   						alert(userId+"님 환영합니다.");			
   					}
   				}).catch(error=>{
					document.querySelector('#idCheck').innerHTML = error;
				})
   			}
   		})
   		
   		
	})();
	
	
	
	
	
	
	
	
	
	