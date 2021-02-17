<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
      <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}"></c:out>/js/check.js"></script>
  <link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"></c:out>/css/UserCreate.css">

  </head>
  <body>
   <form name="frm" action="../deliveryServlet" method="post">
      <div class="header">会員登録</div>
       <input type="hidden" name="command" value="regist"/>
      <span class="guide">*は必須項目です</span><br>
      <label>ID <span>*</span></label>
      <!-- <input type="button" class="idcheck" name="idcheck" value="IDチェック"> -->
      <input type="text" class="input" name="id"/>
      <div class="help">最低6文字以上</div>
      <label>パスワード <span>*</span></label>
		  <c:if test="${sessionScope.dto==null}">
	      <input type="password" class="input" name="pwd"/>   
	      </c:if>     
	      <c:if test="${sessionScope.dto!=null}">
	      <input type="password" class="input" name="pwd" value="${sessionScope.dto.pwd}"/>
	      </c:if>
      <div class="help">半角英数字混合7文字以上</div>
      
      <label>お名前 <span>*</span></label>
       <c:if test="${sessionScope.dto==null}">    
      <input type="text" class="input" name="name"/>
      </c:if>
       
      <c:if test="${sessionScope.dto!=null}">    
      <input type="text" class="input" name="name" value="${sessionScope.dto.id}"/>
      </c:if> 
      
      <div class="help">ex) 末永麻由子</div>
      <label>メールアドレス <span>*</span></label>
          <c:if test="${sessionScope.dto==null}">
      <input type="text" class="input" name="email"/>
      </c:if> 
      
       <c:if test="${sessionScope.dto!=null}">
      <input type="text" class="input" name="email" value="${sessionScope.dto.email}"/>
      </c:if> 
      
      <div class="help">ex) abc123@gmail.com</div>
      <label>住所</label>
      <c:if test="${sessionScope.dto==null}">
      <input type="text" class="input" name="address"/>
      </c:if> 
      
       <c:if test="${sessionScope.dto!=null}">
      <input type="text" class="input" name="address" value="${sessionScope.dto.address}"/>
      </c:if>
      <div class="help">ex) 東京都千代田区丸の内１丁目</div>
      <label>会員選択<span>*</span></label>
      <div>
        <input type="radio" class="select" name="user" value="admin"/>店主
        <input type="radio" class="select" name="user" value="user"/>ユーザー
      </div>
      
      <div class="button_div">
        <input type="submit" value="登録" onclick="return check()">
        <input type="button" class="cancel" value="取り消し" onclick="JavaScript:history.back(-1);">
      </div>
    </form>
 		
  </body>
</html>
