<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			

<form name = "frm" >
<input type = "button" value ="다음123" id = 'aaa'>

<input type="number" id = "cnt" class="plus_minus" name="cnt" value ="0 "min="1" max="20" onClick='check1(this)'>개 
<input type = "button" value ="다음" onClick='check();'>
</form>


<script type="text/javascript">
function check1(e){
	
	var aa = 1234;
	alert(e.value * aa);
	/* alert($('#cnt').val()); */
	/* var tmp = document.getElementsByName('frm')[0].value;
	tmp = $("#exam").val();     */
	
}
function check(){
	var f = document.frm;
	if(f.cnt.value==""){
		alert("값을 넣으세요");
	} else {
		alert("값확인");
		alert(val);
	}
}
</script>

</body>
</html>