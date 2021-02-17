<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
    <link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"></c:out>/css/Cart.css">
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
			<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='../main/Main.jsp'">
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
      <div class="order_top">
        <span>注文のリスト</span>
        <div class="order_text">
          注文したリストを確認できます。
        </div>
      </div>

      <div class="table">
        <div class="row header">
          <div class="cell">
      		      ID
          </div>
          <div class="cell">
         		   お届けエリア
          </div>
          <div class="cell">
         		   ご注文内容
          </div>
          <div class="cell">
            		数量
          </div>
          <div class="cell">
      		      お払い金額
          </div>
        </div>
	<c:forEach var = "list" items="${cartList}">
        <div class="row">
          <div class="cell">
            ${list.id }
          </div>
          <div class="cell">
           		${sessionScope.dto.address }
          </div>
          <div class="cell">
      		      ${list.foodName}
          </div>
          <div class="cell">
            ${list.quantity }
          </div>
          <div class="cell">
            ${list.summoney }
          </div>
        </div>
        </c:forEach>
      </div>     
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