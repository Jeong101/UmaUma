<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>restaurantSlecet</title>
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/restaurantSelect.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/restaurantSelect.js"></script>
  </head>
  <body>
    <div class="header">
			<div class="usermenu">
			<c:if test="${sessionScope.dto==null }">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/login/login.jsp">ログイン</a><span class="bar"> | </span>
				</c:if>
				<c:if test="${sessionScope.dto!=null }">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/login/logOut.jsp">ログアウト</a><span class="bar"> | </span>
				</c:if>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/regist/UserCreate.jsp">会員登録</a><span class="bar"> | </span>
				  <c:if test="${sessionScope.dto!=null}"> 
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/mypage/myPage.jsp">マイページ</a><span class="bar"> | </span>
				 </c:if>
				<a href="https://www.facebook.com/">FACEBOOK</a>
			</div>
			<div class="topmenu">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='Main.jsp'">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp">ホーム</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/worldCup/worldCup.jsp">フードワールドカップ</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/cart/cart.jsp">注文のリスト</a>
				<div class="search">
					<form>
						<input type="text" name="res_name" placeholder="小さいジャンルから探す　ex)牛丼">
						<input type="submit" value="探す">
					</form>
				</div>
			</div>
		</div>
		
		
					
		
			<div class="content">
				<c:forEach var = "list" items = "${store}">
				
			    <div class="content_img" onclick="location.href='/hotdelivery_1/selectStore.do?num=${list.storeNo}'">
			        <div class="img">
			        	<img src='<c:out value = "${list.imgUrl }"/>'>
			        </div>
			        	<!-- <br> -->
			        <h3><a href="#"><c:out value="${list.storeName}"/></a></h3>
			        <div class="location_info"><c:out value = "${list.address }"/></div>
			        	
			        <div class="location-rate-share">
			    		<div class="rateit">
			    			<span> </span>
			    		</div>
			    		<div class="post-share">
			    			<span> </span>
			    		</div>
			        	<div class="location">
			            	<span><a onclick="location.href='/hotdelivery_1/selectStore.do?num=${list.storeNo}'"><label> </label>Location</a></span> 
			         	</div>
			    		<div class="clear"> </div>
			    		</div>
			    	</div>
			    	</c:forEach>
			  </div>
        
        
     
     
    <div class="footer">
			<!-- <hr> -->
			<div class="bottommenu">
				<a href=""><span class="text">ご利用規約</span></a><span class="bar"> | </span>
        <a href=""><span class="text">個人情報処理規約</span></a><span class="bar"> | </span>
        <a href=""><span class="text">採用情報</span></a>
			</div>
			<!-- <hr> -->
		<div class="createrinfo">
	       HOT Delivery Co..Ltd.ALL rights reserved
		</div>
	</div>
  </body>
</html>