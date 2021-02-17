<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"></c:out>/css/Mypage.css">
<script src="../js/mypage.js"></script>
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
				<a href="https://www.facebook.com/Hot-Delivery-556462524698539/">FACEBOOK</a>
			</div>
			<div class="topmenu">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp'">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp">ホーム</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/worldCup/worldCup.jsp">フードワールドカップ</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/cart/cart.jsp">注文のリスト</a>
				<div class="search">
					<form class="search_form">
						<input type="text" name="res_name" placeholder="小さいジャンルから探す　ex)牛丼">
						<input type="submit" value="探す">
					</form>
				</div>
			</div>
		</div>
	
	<div class="content">
      <div class="id_search">
        <div class="pay_top">
          <div class="pay_top_menu">
            <div class="blank"></div>
            <div class="menu" id="tablinks" onclick="openPage(event, '1')">
              | プロフィール修正
            </div>
            <div class="menu" id="tablinks" onclick="openPage(event, '2')">
              | 会員脱退
            </div>
            <c:if test="${sessionScope.dto!=null}">
            <div class="menu" id="tablinks" onclick="openPage(event, '3')">
              | 金額チャージ
            </div>
            </c:if>
            <c:if test="${sessionScope.dto.kind.equals('admin')}">
            <div class="menu" id="tablinks" onclick="openPage(event, '4')">
              | メニュー登録およそ修正
            </div>
            </c:if>
          </div>
        </div>

        <div id="1" class="tabcontent">
          <div class="tab_header">プロフィール修正</div>
          <form action="../deliveryServlet" class="update_form" method="post">
            <div>
              <label>ID </label>
            </div>
            <input type="text" class="input" value="${dto.id}" name="updateId" readonly/>
            <div>
              <label>パスワード </label>
            </div>
            <input type="password" class="input" name="updatePwd"/>
            <div class="help">半角英数字混合7文字以上</div>
            <div>
              <label>メールアドレス </label>
            </div>
            <input type="text" class="input" value="${dto.email }" name="updateEmail"/>
            <div class="help">ex) abc123@gmail.com</div>
            <div>
              <label>住所</label>
            </div>
            <input type="text" class="input" value="${dto.address }" name="updateAddress"/>
            <div class="help">ex) 東京都千代田区丸の内１丁目</div>
			<input type="hidden" value="udpateMember" name="command"/>
              <input type="submit" value="修正">
              <input type="reset" value="取り消し">
          </form>
        </div>



        <div id="2" class="tabcontent">
          <div class="tab_header">会員脱退</div>
          <form action="../deliveryServlet" class="update_form">
            <div class="guide">脱退するユーザーのパスワードを入力してください。</div>
            <div>
              <label>パスワード </label>
            </div>
            <input type="hidden" name="deleteId" value="${dto.id}"/>
            <input type="password" name="deletePwd"/>
            <div class="help">半角英数字混合7文字以上</div>
            <div>
              <label>脱退理由 </label>

            </div>
            <div>
              <input type="text" name="because"/>
            </div>
<input type="hidden" value="deleteMember" name="command"/>
            <input type="submit" value="脱退">
            <input type="reset" value="取り消し">
          </form>
        </div>
        
        <c:if test="${sessionScope.dto!=null}">
        <div id="3" class="tabcontent">
          <div class="tab_header">金額チャージ</div>
          <div>
          	<input type="text" value="${sessionScope.dto.money }" readonly>
          	<form action="../deliveryServlet">
          	<input type="hidden" value="plusMoney" name="command"/>
          		<input type="submit" value="100万ウォンチャージ"> 
          	</form>
          </div>
        </div>
        </c:if>
        
        <c:if test="${sessionScope.dto.kind.equals('admin')}">
        <div id="4" class="tabcontent">
          <div class="tab_header">メニュー登録およそ修正</div>
          <p>メニュー登録およそ修正</p>
        </div>
        </c:if>
        
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