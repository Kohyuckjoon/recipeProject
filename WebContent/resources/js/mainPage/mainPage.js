(() => {
	
		let numberForPaging = (totalPage, viewPageNumbers, currentPage) => {
		
		this.totalPage = totalPage;
		// 1000/36 = 27.7
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
	let sPN = parseInt(sessionStorage.getItem('sessionPageNumber'));
	
	
	if(isNaN(sPN) == true) {
		paging = numberForPaging(28, 10, 1)
	} else {
		paging = numberForPaging(28, 10, sPN)
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
		
		
	}

	
})();