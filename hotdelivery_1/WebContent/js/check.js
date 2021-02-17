/**
 * 우선 빈칸체크 후 회원가입
 * */

function check(){
	if(document.frm.id.value==""){
		alert("IDを入力してください");
		return false;
	}else if(document.frm.id.value.length<6){
		alert("IDを６字以上入力してください");
		return false;
	}
	else if(document.frm.pwd.value==""){
		alert("パスワードを入力してください");
		return false;
	}else if(document.frm.pwd.value.length<7){
		alert("パスワード ７字以上入力してください");
		return false;
	}
	
	else if(document.frm.name.value==""){
		alert("お名前を入力してください");
		return false;
	}else if(document.frm.address.value==""){
		alert("ご住所を入力してください");
		return false;
	}else if(!(document.frm.user.value.equals("admin")||document.frm.user.value.equals("user"))){
		alert("使用目的を選んで選んでください");
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.id.value.length==0){
		alert("ID를 입력해주세요");
		return false;
	}else if(document.frm.pwd.value==""){
		alert("Password를 입력해주세요");
		return false;
	}
	return true;
}