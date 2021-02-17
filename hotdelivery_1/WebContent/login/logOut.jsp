<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
</head>
<body>
<%
	session.invalidate();
	response.sendRedirect("../main/Main.jsp");
%>

</body>
</html>