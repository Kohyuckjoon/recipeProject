/**
 * 
 */
let createPopUp=(popInfo)=>{
		let positionX = screen.width/2 - (popInfo.width/2);
		let positionY = screen.height/2 - (popInfo.height/2);
		
		let popup = open(popInfo.url,popInfo.name,`width=${popInfo.width},height=${popInfo.height},left=${positionX},top=${positionY}`);
		return popup;
	}
