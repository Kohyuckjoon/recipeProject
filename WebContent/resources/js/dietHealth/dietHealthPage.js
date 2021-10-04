(() => {
	
	/* 메인페이지 레시피 화면 구현 자바스크립트*/
	/*console.dir("sPN: "+ sPN);
	console.dir("시작 인덱스 = 4*9*"+sPN+"-36: "+ (sPN*4*9-36));*/
	
	let endNum = 9;
	let recipeDetail =0;
	
	if(sPN == 37){
		endNum = 4;
	}
	
	for(let i = 0; i < endNum; i++){
	
		let rowDiv = document.createElement('div');
		rowDiv.classList.add('row');
		document.querySelector(".lowerBoxLeft").appendChild(rowDiv);
		
		let numForRecipe = (sPN*36-36)+i*4

		
		for(let j = numForRecipe; j < numForRecipe+4; j++){
			/*console.dir(j);*/
			
			
			if(j <= 1314){
				let urDiv = document.createElement('a');
				urDiv.classList.add('upper-recipe');
				urDiv.classList.add('upper-recipe'+recipeIdx[j]);
				let style = document.createAttribute("style");
				style.value = 'cursor:pointer';
				urDiv.setAttributeNode(style);
				let onClick = document.createAttribute("href");
				onClick.value = '/recipePage/recipePage?no='+recipeIdx[j];
				urDiv.setAttributeNode(onClick);
				rowDiv.appendChild(urDiv);
				

		
				let imgDiv = document.createElement('img');
				imgDiv.classList.add('recipe-pic');
				
				let imgSrc = document.createAttribute("src");
				imgSrc.value = recipeImg[j]
				imgDiv.setAttributeNode(imgSrc);
				urDiv.appendChild(imgDiv);
		
				let textAreaDiv = document.createElement('div');
				textAreaDiv.classList.add('recipe-text');
				urDiv.appendChild(textAreaDiv);
		
				let recipeTypeDiv = document.createElement('div');
				recipeTypeDiv.classList.add('recipe-type');
				recipeTypeDiv.append(recipeType[j]);
				textAreaDiv.appendChild(recipeTypeDiv);
		
				let recipeNameDiv = document.createElement('div');
				recipeNameDiv.classList.add('recipe-name');
				recipeNameDiv.append(recipeName[j]);
				textAreaDiv.appendChild(recipeNameDiv);
		
				let recipeStarDiv = document.createElement('div');
				recipeStarDiv.classList.add('recipe-star');
				recipeStarDiv.append("★★★★★");
				textAreaDiv.appendChild(recipeStarDiv);
				
				document.querySelector('.upper-recipe'+recipeIdx[j]).addEventListener('click',() =>{
					recipeDetail=recipeIdx[j];
					sessionStorage.setItem('recipeDetailIdx', recipeDetail);
					location.href="/recipePage/recipePage";
				}); 
			}
			
		}
		/*console.dir("");*/
	}
	
	/* 페이징 구현 자바스크립트*/
	let numberForPaging = (totalPage, viewPageNumbers, currentPage) => {
		
		this.totalPage = totalPage;
		// 1315/36 = 36.5
		this.currentPage = currentPage;
		this.viewPageNumbers = viewPageNumbers;
		let remainder = currentPage % viewPageNumbers;
		let firstPagerNum = currentPage - remainder + 1;
		
		let lastPagerNum = currentPage - remainder + viewPageNumbers;
																		
		if(remainder == 0){
			firstPagerNum -= 10;
			lastPagerNum -= 10;
		}
		
		if(this.totalPage < lastPagerNum ){
			lastPagerNum = this.totalPage; 
		}
		
		return{
			totalPage,
			currentPage,
			viewPageNumbers,
			firstPagerNum,
			lastPagerNum
		}
		
	}
	
	let paging = null;
	
	if(isNaN(sPN) == true) {
		paging = numberForPaging(37, 10, 1)
	} else {
		paging = numberForPaging(37, 10, sPN)
	}
	
	for(let i = paging.firstPagerNum; i < paging.lastPagerNum + 1; i++){
		let pageNumber = document.createElement('td');
		pageNumber.classList.add('page-' + i);
		pageNumber.append(i);
		document.querySelector('.num').before(pageNumber);
		
		document.querySelector('.page-' + i).addEventListener('click',() =>{
			sessionStorage.setItem('sessionPageNumber', i );
			location.href="/mainPage/clickedPage";
		});
		
		if (i != sPN) {
			document.querySelector('.page-' + i).addEventListener('mouseover',() =>{
				let mouseOnPage = document.querySelector('.page-'+i)
				let insertColorIntoMouseOnPage = document.createAttribute("style");
				insertColorIntoMouseOnPage.value = "border-bottom:1px solid black";
				mouseOnPage.setAttributeNode(insertColorIntoMouseOnPage);
			});
			
			document.querySelector('.page-' + i).addEventListener('mouseout',() =>{
				let mouseOnPage = document.querySelector('.page-'+i)
				let insertColorIntoMouseOnPage = document.createAttribute("style");
				mouseOnPage.setAttributeNode(insertColorIntoMouseOnPage);
			});
		} 
		
		
	}
	
	document.querySelector('.prevPage').addEventListener('click',() =>{
		
		if (sPN == 1) {
			sPN = 1
		} else {
			sPN -= 1;
		}
		
		sessionStorage.setItem('sessionPageNumber', sPN);
		location.href="/mainPage/clickedPage";
	});
	
	document.querySelector('.nextPage').addEventListener('click',() =>{
		
		if (sPN == 37) {
			sPN = 37
		} else {
			sPN += 1;
		}
		
		sessionStorage.setItem('sessionPageNumber', sPN);
		location.href="/mainPage/clickedPage";
	});
	
	document.querySelector('.prevPrevPage').addEventListener('click',() =>{
		
		if (sPN <= 10) {
			sPN = 1
		} else if(sPN%10 == 0){
			sPN -= 19;
		} else{
			sPN = sPN - (9 + sPN%10);
		}
		
		sessionStorage.setItem('sessionPageNumber', sPN);
		location.href="/mainPage/clickedPage";
	});
	
	document.querySelector('.nextNextPage').addEventListener('click',() =>{
		
		if (sPN >= 31) {
			sPN = 37
		} else if(sPN%10 == 0){
			sPN += 1;
		} else{
			sPN = sPN + (11 - sPN%10);
		}
		sessionStorage.setItem('sessionPageNumber', sPN);
		location.href="/mainPage/clickedPage";
	}); 
	
	let currentPage = document.querySelector('.page-'+sPN)
	let insertColorIntoCurrentPage = document.createAttribute("style");
	insertColorIntoCurrentPage.value = "background-color:lightblue";
	currentPage.setAttributeNode(insertColorIntoCurrentPage);

	
})();