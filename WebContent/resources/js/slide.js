/**
 * 
 */

/* cnt값을 즉시실행함수로 감싸서, 전역에서 격리시킨다.
   이벤트리스너에 등록된 콜백함수들이 closure 역할을 해준다.   */
(function(){
   let cnt = 0;   
   $(".arrow-right").addEventListener('click',()=>{
      cnt++;
      if(cnt > 3){
         cnt = 0;
      }
      
      moveSlide(cnt);
   });
   
   $(".arrow-left").addEventListener('click',()=>{
      cnt--;
      if(cnt < 0){
         cnt = 3;
      }
      
      moveSlide(cnt);
   });
})();  

document.querySelectorAll('.btn_slide>button').forEach((element) => {
   element.addEventListener('click',(event) => {
      let slideIdx = event.target.dataset.slideIdx;
      moveSlide(slideIdx);
   })
})

let moveSlide = (cnt) => {
   document.querySelectorAll('.slide>li').forEach((e)=>{
      e.style.transform=`translateX(${cnt * -100}%)`;
      e.style.transitionDuration = '0.5s';
   })
}