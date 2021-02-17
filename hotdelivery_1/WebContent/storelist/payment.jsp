<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/order.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/order.js"> </script>
  </head>
  
  <body>
    <div class="header">
			<div class="usermenu">
        <a href="login.html">ログイン</a><span class="bar"> | </span>
				<a href="UserCreate.html">会員登録</a><span class="bar"> | </span>
				<a href="mypage.html">マイページ</a><span class="bar"> | </span>
				<a href="https://www.facebook.com/Hot-Delivery-556462524698539/">FACEBOOK</a>
			</div>
			<div class="topmenu">
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='Main.html'">
				<a href="Main.html">ホーム</a><span class="bar"> | </span>
				<a href="">フードワールドカップ</a><span class="bar"> | </span>
				<a href="Cart.html">注文のリスト</a>
				<div class="search">
					<form>
            <input type="text" name="res_name" placeholder="小さいジャンルから探す　ex)牛丼">
						<input type="submit" value="探す">
					</form>
				</div>
			</div>
		</div>

    <div class="order_frame">
      <div class="a">
        <div class="Slides">
          <div class="head">
          お支払い
          </div>
          <div class="content">
            <p>お支払い金額は  &nbsp;&nbsp; '<c:out value = "${sum}"/>'&nbsp;&nbsp;ウォン です。</p><br>
            <p>お支払いしますか？</p>

            <div class="pay_button">
              <input type="button" value="お支払い" data-needpopup-show="#id_search">
              <input type="button" value="取り消し" onclick="location.htef='restaurantSelect.html'">
            </div>

            <div id='id_search' class="needpopup">
              <a href="" class="needpopup_remover" onclick="location.href='./main/Main.jsp'">x</a>
              <div class="pay_top">
                <img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/payco.png" alt="payco" width="88px" height="24px">
                <div class="pay_top_menu">
                  <div>
                    | お支払い
                  </div>
                </div>
              </div>

              <div class="pay_main">

                <form name="frm" action="<c:out value="${pageContext.request.contextPath}"></c:out>/deliveryServlet" method="post">
                <div class="header">ご注文情報確認</div>
                <table>
                  <tr>
                    <td class="td_name">お支払い金額</td>
                    <td><input type="text" id="summoney_input" name="summoney" value="<c:out value = "${sum}"/>"/></td>
                  </tr>
                  <tr>
                    <td class="td_name">お名前</td>
                    <td><input type="text" id="name_input" name="name" value="<c:out value = "${sessionScope.dto.name}"/>"/></td>
                  </tr>
                  <tr>
                    <td class="td_name">E-Mail</td>
                    <td><input type="text" id="email_input" name="email" value="<c:out value = "${sessionScope.dto.email}"/>"/></td>
                  </tr>
                  <tr>
                  
                    <td class="td_name">財布</td>
                    <td><input type="text" id="money_input" name="money" value="<c:out value = "${sessionScope.dto.money}"/>" readonly/></td>
                  </tr>
                  <tr>
                    <td class="td_name">電話番号</td>
                    <td><input type="text" name="phone"/></td>
                  </tr>
                  
                  <tr>
                    <td><input type="button" value="電話番号確認" onclick="phone_ok()"></td>
                    <td><input type="text" name="phonecheck"></td>
                  </tr>
                </table>
	`				<input type="hidden" value="registCart" name="command"/>
                <input type="submit"  value="お支払い" onclick="return payment_ok()">

              </form>
              </div>
      			</div>

          </div>
        </div>
      </div>
    </div>
	
    <div class="footer">
      <div class="bottommenu">
        <a href=""><span class="text">ご利用規約</span></a><span class="bar"> | </span>
        <a href=""><span class="text">個人情報処理規約</span></a><span class="bar"> | </span>
        <a href=""><span class="text">採用情報</span></a>
      </div>
      <div class="createrinfo">
        HOT Delivery Co<c:out value="${pageContext.request.contextPath}"></c:out>Ltd.ALL rights reserved
      </div>
    </div>

    
    <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
  		<script src="./js/needpopup.js"></script>
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
