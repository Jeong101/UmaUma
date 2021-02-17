<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
  <head>
    <title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
    <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"></c:out>/js/check.js"></script>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"></c:out>/css/Login.css">
 
  </head>
  <body>
  <c:if test="${msg!=null }">
  <font color="red" size="5">${msg}</font>
  </c:if>
    
  <form name="frm" action="/hotdelivery_1/deliveryServlet" method="post">
    <div class="header">ログイン</div>
    <input type="hidden" value="login" name="command"/>
    
    <label>ID  
    <c:if test="${requestScope.findId!=null }">
  	<font color="red">検索したIDは${requestScope.findId }</font>
  	</c:if>
  	</label>
   
    <c:if test="${sessionScope.dto.id==null }">
    <input type="text" name="id" value="${sessionScope.dto.id}"/>

    </c:if>
    <c:if test="${sessionScope.dto.id!=null }">
    <input type="text" name="id" value="${sessionScope.dto.id}" />
    </c:if> 
    <label>パスワード  <c:if test="${requestScope.findPwd!=null }">
  	<font color="red">検索したパスワードは${requestScope.findPwd }</font>
  	</c:if></label>
    <input type="password" name="pwd"/>
    <input type="submit" value="ログイン"  onclick="return idCheck()">
    <a href="" data-needpopup-show="#id_search">ID検索</a>
  	<a href="" data-needpopup-show="#pwd_search">パスワード検索</a>		
  </form>
  			
	
  <div id='id_search' class="needpopup">
  	<div class="header">ID検索</div>
	    <form class="find_form" name="findFrm" action="/hotdelivery_1/deliveryServlet">
	      <label>お名前 </label>
	      <input type="hidden" value="findId" name="command"/>
	      <input type="text" name="findName"/>
	      <div class="help">EX)　末永真由子</div>
	      <label>メールアドレス </label>
	      <input type="text" name="findEmail"/>
	      <div class="help">登録されているメールアドレス</div>
	      <input type="submit" value="探す">		
		</form>
  	</div>
  			
  <div id='pwd_search' class="needpopup">
  	<div class="header">パスワード検索</div>
  	
  		<form class="find_form" action="/hotdelivery_1/deliveryServlet">	
          <input type="hidden" value="findPwd" name="command"/>
          <label>ID </label>
          <input type="text" name="findpwdId"/>
          <div class="help">登録されているID</div>
          <label>お名前 </label>
          <input type="text" name="findpwdName"/>
          <div class="help">EX)　末永麻由子</div>
          <label>メールアドレス </label>
          <input type="text" name="findpwdEmail"/>
          <div class="help">登録されているメールアドレス</div>
          <input type="submit" value="探す">			
  		</form>
 	 </div>
 	 
 <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="../js/needpopup.js"></script>
		<script>
			needPopup.config.custom = {
				'removerPlace': 'outside',
				'closeOnOutside': false,
				onShow: function() {
					console.log('needPopup is shown');
				},
				onHide: function() {
					console.log('needPopup is hidden');
				}
			};
			needPopup.init();
		</script>

  </body>
</html>
