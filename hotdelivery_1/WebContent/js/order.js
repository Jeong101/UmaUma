var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  // var y=document.getElementsByClassName("masimg");
  // if(n==1){
  //   y[0].style.animation="2s moveRight ease-in-out";
  //   showDivs(slideIndex += n);
  // }
  // else{
  //   y[0].style.animation="2s moveLeft ease-in-out";
  //   showDivs(slideIndex += n);
  // }
	
    slideIndex += n;
    if(slideIndex<1){
      alert("最初のページです");
      slideIndex=1;
    }else if(slideIndex>2){
      alert("最後のページです");
      slideIndex=2;
    }else {
      showDivs(slideIndex);
    }
    // showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("Slides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  x[slideIndex-1].style.display = "block";
}

function phone_ok(){
	var result = Math.floor(Math.random() * 9999) + 1000;

	alert(result);//랜덤값 숫자4자리
	
}

function cancel(){
  location.href='main.jsp'
  alert("チャンセル　またお店から選んでください");
}



function payment_ok(){	
	var money = parseInt(document.frm.money.value);
	var price = parseInt(document.frm.summoney.value);
	
	if(money>=price){
		alert("完了");
	}
	if(money<price){
		alert("잔액 부족 충전페이지로");

	}
	return true;
}
