(() => {
	let rDI = sessionStorage.getItem('recipeDetailIdx');
	
	let recipeDbOrder = recipeIdx.indexOf(rDI);
	
	let imgDiv = document.createElement('img');
	imgDiv.classList.add('recipe-img');
	
	let imgSrc = document.createAttribute("src");
	imgSrc.value = recipeImg[recipeDbOrder]
	imgDiv.setAttributeNode(imgSrc);
	document.querySelector(".recipe-page").prepend(imgDiv);
	
	let recipeTypeDiv = document.createElement('div');
	recipeTypeDiv.classList.add('recipe-type');
	recipeTypeDiv.append(recipeType[recipeDbOrder]);
	document.querySelector(".container").prepend(recipeTypeDiv);
	
	let recipeNameDiv = document.createElement('div');
	recipeNameDiv.classList.add('recipe-name');
	recipeNameDiv.append(recipeName[recipeDbOrder]);
	document.querySelector(".container").prepend(recipeNameDiv);
	
	let caloryDiv = document.createElement('div');
	caloryDiv.classList.add('calory');
	caloryDiv.append("◉ 열량 : " + caloryArr[recipeDbOrder]);
	document.querySelector(".nutrient-detail").appendChild(caloryDiv);
	
	let carbohydrateDiv = document.createElement('div');
	carbohydrateDiv.classList.add('calory');
	carbohydrateDiv.append("◉ 탄수화물 : " + carbohydrateArr[recipeDbOrder]);
	document.querySelector(".nutrient-detail").appendChild(carbohydrateDiv);
	
	let proteinDiv = document.createElement('div');
	proteinDiv.classList.add('calory');
	proteinDiv.append("◉ 단백질 : " + proteinArr[recipeDbOrder]);
	document.querySelector(".nutrient-detail").appendChild(proteinDiv);
	
	let fatDiv = document.createElement('div');
	fatDiv.classList.add('calory');
	fatDiv.append("◉ 지방 : " + fatArr[recipeDbOrder]);
	document.querySelector(".nutrient-detail").appendChild(fatDiv);
	
	let natriumDiv = document.createElement('div');
	natriumDiv.classList.add('calory');
	natriumDiv.append("◉ 나트륨 : " + natriumArr[recipeDbOrder]);
	document.querySelector(".nutrient-detail").appendChild(natriumDiv);
	
	let ingredientsDiv = document.createElement('div');
	ingredientsDiv.classList.add('ingredients-split');
	ingredientsDiv.append(ingredientsArr[recipeDbOrder]);
	document.querySelector(".ingredients-detail").appendChild(ingredientsDiv);
	
	
	if(manualImg1[recipeDbOrder]){
		let manualImg1Div = document.createElement('img');
		manualImg1Div.classList.add('cooking-method-detail-img');

		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg1[recipeDbOrder]
		manualImg1Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg1Div);
	}
	
	if(manual1[recipeDbOrder]){
		let manual1Div = document.createElement('div');
		manual1Div.classList.add('cooking-method-detail-txt');
		manual1Div.append(manual1[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual1Div);
	}
	
	if(manualImg2[recipeDbOrder]){
		let manualImg2Div = document.createElement('img');
		manualImg2Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg2[recipeDbOrder]
		manualImg2Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg2Div);
	}
	
	if(manual2[recipeDbOrder]){
		let manual2Div = document.createElement('div');
		manual2Div.classList.add('cooking-method-detail-txt');
		manual2Div.append(manual2[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual2Div);
	}
	
	if(manualImg3[recipeDbOrder]){
		let manualImg3Div = document.createElement('img');
		manualImg3Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg3[recipeDbOrder]
		manualImg3Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg3Div);
	}
	
	if(manual3[recipeDbOrder]){
		let manual3Div = document.createElement('div');
		manual3Div.classList.add('cooking-method-detail-txt');
		manual3Div.append(manual3[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual3Div);
	}
	
	if(manualImg4[recipeDbOrder]){
		let manualImg4Div = document.createElement('img');
		manualImg4Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg4[recipeDbOrder]
		manualImg4Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg4Div);
	}
	
	if(manual4[recipeDbOrder]){
		let manual4Div = document.createElement('div');
		manual4Div.classList.add('cooking-method-detail-txt');
		manual4Div.append(manual4[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual4Div);
	}
	
	if(manualImg5[recipeDbOrder]){
		let manualImg5Div = document.createElement('img');
		manualImg5Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg5[recipeDbOrder]
		manualImg5Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg5Div);
	}
	
	if(manual5[recipeDbOrder]){
		let manual5Div = document.createElement('div');
		manual5Div.classList.add('cooking-method-detail-txt');
		manual5Div.append(manual5[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual5Div);
	}
	
	if(manualImg6[recipeDbOrder]){
		let manualImg6Div = document.createElement('img');
		manualImg6Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg6[recipeDbOrder]
		manualImg6Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg6Div);
	}
	
	if(manual6[recipeDbOrder]){
		let manual6Div = document.createElement('div');
		manual6Div.classList.add('cooking-method-detail-txt');
		manual6Div.append(manual6[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual6Div);
	}
	
	if(manualImg7[recipeDbOrder]){
		let manualImg7Div = document.createElement('img');
		manualImg7Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg7[recipeDbOrder]
		manualImg7Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg7Div);
	}
	
	if(manual7[recipeDbOrder]){
		let manual7Div = document.createElement('div');
		manual7Div.classList.add('cooking-method-detail-txt');
		manual7Div.append(manual7[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual7Div);
	}
	
	if(manualImg8[recipeDbOrder]){
		let manualImg8Div = document.createElement('img');
		manualImg8Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg8[recipeDbOrder]
		manualImg8Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg8Div);
	}
	
	if(manual8[recipeDbOrder]){
		let manual8Div = document.createElement('div');
		manual8Div.classList.add('cooking-method-detail-txt');
		manual8Div.append(manual8[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual8Div);
	}
	
	if(manualImg9[recipeDbOrder]){
		let manualImg9Div = document.createElement('img');
		manualImg9Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg9[recipeDbOrder]
		manualImg9Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg9Div);
	}
	
	if(manual9[recipeDbOrder]){
		let manual9Div = document.createElement('div');
		manual9Div.classList.add('cooking-method-detail-txt');
		manual9Div.append(manual9[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual9Div);
	}
	
	if(manualImg10[recipeDbOrder]){
		let manualImg10Div = document.createElement('img');
		manualImg10Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg10[recipeDbOrder]
		manualImg10Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg10Div);
	}
	
	if(manual10[recipeDbOrder]){
		let manual10Div = document.createElement('div');
		manual10Div.classList.add('cooking-method-detail-txt');
		manual10Div.append(manual10[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual10Div);
	}
	
	if(manualImg11[recipeDbOrder]){
		let manualImg11Div = document.createElement('img');
		manualImg11Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg11[recipeDbOrder]
		manualImg11Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg11Div);
	}
	
	if(manual11[recipeDbOrder]){
		let manual11Div = document.createElement('div');
		manual11Div.classList.add('cooking-method-detail-txt');
		manual11Div.append(manual11[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual11Div);
	}
	
	if(manualImg12[recipeDbOrder]){
		let manualImg12Div = document.createElement('img');
		manualImg12Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg12[recipeDbOrder]
		manualImg12Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg12Div);
	}
	
	if(manual12[recipeDbOrder]){
		let manual12Div = document.createElement('div');
		manual12Div.classList.add('cooking-method-detail-txt');
		manual12Div.append(manual12[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual12Div);
	}
	
	if(manualImg13[recipeDbOrder]){
		let manualImg13Div = document.createElement('img');
		manualImg13Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg13[recipeDbOrder]
		manualImg13Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg13Div);
	}
	
	if(manual13[recipeDbOrder]){
		let manual13Div = document.createElement('div');
		manual13Div.classList.add('cooking-method-detail-txt');
		manual13Div.append(manual13[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual13Div);
	}
	
	if(manualImg14[recipeDbOrder]){
		let manualImg14Div = document.createElement('img');
		manualImg14Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg14[recipeDbOrder]
		manualImg14Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg14Div);
	}
	
	if(manual14[recipeDbOrder]){
		let manual14Div = document.createElement('div');
		manual14Div.classList.add('cooking-method-detail-txt');
		manual14Div.append(manual14[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual14Div);
	}
	
	if(manualImg15[recipeDbOrder]){
		let manualImg15Div = document.createElement('img');
		manualImg15Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg15[recipeDbOrder]
		manualImg15Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg15Div);
	}
	
	if(manual15[recipeDbOrder]){
		let manual15Div = document.createElement('div');
		manual15Div.classList.add('cooking-method-detail-txt');
		manual15Div.append(manual15[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual15Div);
	}
	
	if(manualImg16[recipeDbOrder]){
		let manualImg16Div = document.createElement('img');
		manualImg16Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg16[recipeDbOrder]
		manualImg16Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg16Div);
	}
	
	if(manual16[recipeDbOrder]){
		let manual16Div = document.createElement('div');
		manual16Div.classList.add('cooking-method-detail-txt');
		manual16Div.append(manual16[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual16Div);
	}
	
	if(manualImg17[recipeDbOrder]){
		let manualImg17Div = document.createElement('img');
		manualImg17Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg17[recipeDbOrder]
		manualImg17Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg17Div);
	}
	
	if(manual17[recipeDbOrder]){
		let manual17Div = document.createElement('div');
		manual17Div.classList.add('cooking-method-detail-txt');
		manual17Div.append(manual17[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual17Div);
	}
	
	if(manualImg18[recipeDbOrder]){
		let manualImg18Div = document.createElement('img');
		manualImg18Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg18[recipeDbOrder]
		manualImg18Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg18Div);
	}
	
	if(manual18[recipeDbOrder]){
		let manual18Div = document.createElement('div');
		manual18Div.classList.add('cooking-method-detail-txt');
		manual18Div.append(manual18[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual18Div);
	}
	
	if(manualImg19[recipeDbOrder]){
		let manualImg19Div = document.createElement('img');
		manualImg19Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg19[recipeDbOrder]
		manualImg19Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg19Div);
	}
	
	if(manual19[recipeDbOrder]){
		let manual19Div = document.createElement('div');
		manual19Div.classList.add('cooking-method-detail-txt');
		manual19Div.append(manual19[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual19Div);
	}
	
	if(manualImg20[recipeDbOrder]){
		let manualImg20Div = document.createElement('img');
		manualImg20Div.classList.add('cooking-method-detail-img');
		
		let imgSrc = document.createAttribute("src");
		imgSrc.value = manualImg20[recipeDbOrder]
		manualImg20Div.setAttributeNode(imgSrc);
		document.querySelector(".cooking-method-detail").appendChild(manualImg20Div);
	}
	
	if(manual20[recipeDbOrder]){
		let manual20Div = document.createElement('div');
		manual20Div.classList.add('cooking-method-detail-txt');
		manual20Div.append(manual20[recipeDbOrder]);
		document.querySelector(".cooking-method-detail").appendChild(manual20Div);
	}
	
	let textAreaContents = null;
	
	document.querySelector('.reply-submit').addEventListener('mouseover',() =>{
		
		if(onLogin == 'needToLogin'){
			document.querySelector('.reply-submit').addEventListener('mouseover',() =>{
				alert("로그인 해주세요");
			});
		}else{
			textAreaContents = document.querySelector(".reply-text").value ;
			let postComment = document.querySelector(".reply-submit");
			let bLocation = document.createAttribute("onclick");
			let stringLocation = "location.href = '/recipePage/recipePageForReview?no="
			bLocation.value = stringLocation+rDI+"&replyContents="+textAreaContents+"\'";
			postComment.setAttributeNode(bLocation);
		}
		
	});
	
	let onclickScrap = document.createAttribute("onclick");
	let scrapLocation = "location.href = '/recipePage/addScr?rcpSeq="
	onclickScrap.value = scrapLocation+rDI+"\'";
	document.querySelector(".scrap").setAttributeNode(onclickScrap);
	

})();

















