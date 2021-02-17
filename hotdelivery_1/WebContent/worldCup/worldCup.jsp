<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
	 <link rel="stylesheet" href="../css/Worldcup.css">
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
				<c:if test="${sessionScope.dto==null }">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/regist/UserCreate.jsp">会員登録</a><span class="bar"> | </span>
				</c:if>
				  <c:if test="${sessionScope.dto!=null}"> 
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/mypage/myPage.jsp">マイページ</a><span class="bar"> | </span>
				 </c:if>
				<a href="https://www.facebook.com/Hot-Delivery-556462524698539/">FACEBOOK</a>
			</div>
			<div class="topmenu">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp'">
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
      <div class="start">
        <a href="../deliveryServlet?command=worldCup"><img src="../image/textbox1.png"></a>
      </div>
    </div>

    <div class="footer">
			<div class="bottommenu">
				<a href=""><span class="text">ご利用規約</span></a><span class="bar"> | </span>
        <a href=""><span class="text">個人情報処理規約</span></a><span class="bar"> | </span>
        <a href=""><span class="text">採用情報</span></a>
			</div>
			<div class="createrinfo">
	       HOT Delivery Co..Ltd.ALL rights reserved
			</div>
		</div>
  </body>
</html>