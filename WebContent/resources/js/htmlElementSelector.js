/**
 * 
 */
let $ = (selector, text, styleFnc) => {
	
	let e = document.querySelector(selector);
	
	if(text){
		e.innerHTML += `${text}<br>`;
		
	}
	//매개변수로 전달받은 함수를 요소객체를 전달하고 호출
	if(styleFnc){
		styleFnc(e);
		
	}
	
	return e;
}