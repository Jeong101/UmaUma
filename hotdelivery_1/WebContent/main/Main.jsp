<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
	<head>	
		<title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"></c:out>/css/Main.css">
		
	</head>
	<body>
		<div class="header">
			<div class="usermenu">
			<c:if test="${sessionScope.dto==null }">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/login/login.jsp">ログイン</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/regist/UserCreate.jsp">会員登録</a><span class="bar"> | </span>
				</c:if>
				<c:if test="${sessionScope.dto!=null }">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/login/logOut.jsp">ログアウト</a><span class="bar"> | </span>
				</c:if>
				
				  <c:if test="${sessionScope.dto!=null}"> 
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/mypage/myPage.jsp?command=myPageForm&dto=<c:out value='${sessionScope.dto}'/>">マイページ</a><span class="bar"> | </span>
				 </c:if>
				<a href="https://www.facebook.com/">FACEBOOK</a>
			</div>
			<div class="topmenu">			
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp'">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp">ホーム</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/worldCup/worldCup.jsp">フードワールドカップ</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/deliveryServlet?command=cartList&dto=${sessionScope.dto}">注文のリスト</a>
				<div class="search">
					<form action = "../StoreSearchServlet" method="post">
						<input type="text" name="search" placeholder="小さいジャンルから探す　ex)牛丼">
						<input type="submit" value="探す">
					</form>
				</div>
			</div>
		</div>
		<div id="slider">
			<div class="slider_figure">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/ev1.jpg" alt="event1" onclick="location.href='Main.jsp';">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/ev2.jpg" alt="event2" onclick="location.href='../worldCup/worldCup.jsp';">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/ev3.jpg" alt="event3" onclick="location.href='Main.jsp';">
			</div>
		</div>
		<!-- <div class="searchimg">
			<img src="../image/searchimg.png" alt="searchimg" width="20" height="20"><span>ジャンルから探す</span>
		</div> -->
		<div class="content">
			<fieldset>
				<legend>
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/searchimg.png" alt="searchimg" width="20" height="20"><span>大きいジャンルから探す</span>
				</legend>				
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/allmenu.jpg" alt="allmenu" onclick="location.href='restaurantSelect.html'">
				
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/deliveryServlet?command=kfood&num=4"><img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/korean1.jpg" alt="korean1"></a>	<!-- 한국나옴.. -->
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/deliveryServlet?command=cfood&num=3"><img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/chinese1.jpg" alt="chinese1"></a>	<!-- 중식나옴 -->
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/deliveryServlet?command=jfood&num=2"><img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/japanese.jpg" alt="japanese"></a>	<!-- 일식나옴 -->
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/deliveryServlet?command=wfood&num=1"><img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/western.jpg" alt="western"></a>	<!-- 양식나옴 -->
				
			</fieldset>
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
