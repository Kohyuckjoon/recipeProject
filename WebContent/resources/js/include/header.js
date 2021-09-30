(() => {

	document.querySelector('.title').addEventListener('click',() =>{
		location.href="/mainPage/mainPage";
	});
	
	document.querySelector('.mainPageButton').addEventListener('click',() =>{
		location.href="/mainPage/mainPage";
	});
	
	document.querySelector('.recipePageButton').addEventListener('click',() =>{
		location.href="/dietHealth/searchResult";
	});
	
	document.querySelector('.boardPageButton').addEventListener('click',() =>{
		location.href="/board/board-list";
	});
	
	document.querySelector('.myPageButton').addEventListener('click',() =>{
		location.href="/myPage/myPage";
	});
	
	document.querySelector('.login_btn').addEventListener('click',() =>{
		location.href="/member/login";
	});



})();