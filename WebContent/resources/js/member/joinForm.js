/* 
	1. 이미 존재하는 아이디로 사용자가 가입하려는 경우 
	2. 비밀번호는 영어, 숫자, 특수문자 조합의 8자리 이상의 문자열
	3. 전화번호는 숫자로만 입력 */
	(()=>{
		let confirmId = '';
   		document.querySelector("#btnIdCheck").addEventListener('click', e => {

   			//id속성값이 지정되어있으면 id값으로 해당 요소객체 호출 가능
   			let id = userId.value;
   			
   			if(id){
   				fetch('/member/id-check?userId=' + id)
   				.then(response => {
					if(!response.ok) throw new Error(`${response.statusText} : ${response.status}`);
					return response.text();
					}).then(text => {
					if(text == 'available'){
   						document.querySelector('#idCheck').innerHTML ='사용 가능한 아이디 입니다.';   	
   						confirmId = id;
   					}else if(text == 'disable'){
   						document.querySelector('#idCheck').innerHTML ='사용 불가능한 아이디 입니다.';   						
   					}
   				}).catch(error=>{
					document.querySelector('#idCheck').innerHTML = error;
				})
   			}
   		})
   		
   		document.querySelector('#frm_join').addEventListener('submit', e => {
   			
   			let pwReg = /(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9])(?=.{8,})/;
   			let tellReg = /^\d{9,11}$/;
   			
   			if(confirmId != userId.value){
   				e.preventDefault();
   				document.querySelector('#idCheck').innerHTML ='아이디 중복 검사를 통과하지 않았습니다.';   	
   			}
   			
   			if(!pwReg.test(password.value)){
   				e.preventDefault();
   				document.querySelector('#pwCheck').innerHTML ='영어,숫자,특수문자 조합의 8~14자의 문자열'; 
   			}
   			
   			if(!tellReg.test(phone.value)){
   				e.preventDefault();
   				document.querySelector('#tellCheck').innerHTML ='-를 제외한 11자리까지입니다.'; 
   			}
   		})
	})();
	
	
	
	
	
	
	
	
	
	