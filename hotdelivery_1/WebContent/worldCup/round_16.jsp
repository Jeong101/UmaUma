<%@page import="delivery.worldcup.dto.FoodDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
		<link rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}"></c:out>/css/Worldcup_sel.css">
		
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



	<c:if test="${sessionScope.round==8}">
	<%
		int cnt=0;
		session.setAttribute("cnt",cnt);		
	%>
	</c:if>
	<c:if test="${sessionScope.round==12}">
	<%
		int cnt=0;
		session.setAttribute("cnt",cnt);		
	%>
	</c:if>
	
	<c:if test="${sessionScope.round==14}">
	<%
		int cnt=0;
		session.setAttribute("cnt",cnt);		
	%>
	</c:if>
	
	<c:if test="${sessionScope.round==15}">
	<%
		int cnt=0;
		session.setAttribute("cnt",cnt);		
	%>
	</c:if>
	<c:if test="${sessionScope.round==16}">
	<%
		int cnt=0;
		session.setAttribute("cnt",cnt);		
	%>
	</c:if>

<div class="content">
      <div class="round">
      	<c:if test="${sessionScope.round<8 }">ベスト16</c:if>
      	<c:if test="${sessionScope.round>7 && sessionScope.round<12 }">ベスト8</c:if>
       	<c:if test="${sessionScope.round>11 && sessionScope.round<14 }">ベスト4</c:if>
       	<c:if test="${sessionScope.round>13 && sessionScope.round<15 }">決勝</c:if>
       	<c:if test="${sessionScope.round==15 }">最終</c:if><br>
      	 ${sessionScope.round+1}ROUND
      </div>
      <div class="round_num">
          
      </div>
      <div class="foodselect">
      
      
<c:forEach var = "worldCup" items="${list}" begin="${cnt}" end="${cnt+1 }">
    

        <div class="food_1">
          <div class="food_info">${worldCup.foodKind}</div>
          <c:if test= "${sessionScope.round==15  }">
          <a href="<c:out value='${pageContext.request.contextPath}'>
	   	</c:out>/deliveryServlet?command=foodFind&num=${worldCup.foodNo}"><img src="${worldCup.imgUrl}" alt="food_1"></a>
          </c:if>
        <c:if test= "${sessionScope.round!=15  }">
          <a href="<c:out value='${pageContext.request.contextPath}'>
		</c:out>/deliveryServlet?command=winNo&num=${worldCup.foodNo}"><img src="${worldCup.imgUrl}" alt="food_1"></a>
		</c:if>
        </div>

      
    
	</c:forEach> 
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