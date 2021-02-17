<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "delivery.store.dto.StoreDTO" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
      <meta charset="UTF-8">
      <title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
      <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/css/listStore.css">
      <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=UqVySwksr8nrfXzw7enb&submodules=geocoder"></script>
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
			<!-- 여기 같은데 안댐-->
				<img src="<c:out value="${pageContext.request.contextPath}"></c:out>/image/hot_delivery.png" alt="logo" onclick="location.href='<c:out value='${pageContext.request.contextPath}'></c:out>/main/Main.jsp'">
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/main/Main.jsp">ホーム</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/worldCup/worldCup.jsp">フードワールドカップ</a><span class="bar"> | </span>
				<a href="<c:out value="${pageContext.request.contextPath}"></c:out>/cart/cart.jsp">注文のリスト</a>
				<div class="search">
					<form action = "<c:out value="${pageContext.request.contextPath}"></c:out>/StoreSearchServlet" method="post">
						<input type="text" name="search" placeholder="小さいジャンルから探す　ex)牛丼">
						<input type="submit" value="探す">
					</form>
				</div>
			</div>
		</div>  
  
  	<div class="content">
      <div class="all_store_div">
        <div class="store_list">
        	  お店のリスト
        </div>
        
		<% int i=0; %>
		<c:forEach var = "list" items = "${storedto}">
		<%System.out.print("i="+i); %>
        <div class="store_div" onclick="">
          <div class="store_img">
            <img src="./image/<%=i%>_spot.png" alt="spot">
          </div>
          <div class="store_name">${list.storeName}</div>
          <div class="store_add">${list.address}</div>
          <div class="store_phone">${list.storePhone}</div>
          <%  i++;%>
        </div>
        </c:forEach>

      </div>
      
      <div id="map"></div>
      
      <script>
   
   	var myaddress=null;
      var map = new naver.maps.Map('map');
      map.setZoom(8);	//줌
      
      
  	var myaddress = '대전광역시 중구 용두동 35-13 희영빌딩 5층';// 도로명 주소나 지번 주소만 가능

      naver.maps.Service.geocode({address: myaddress}, function(status, response) {
         
          if (!status == naver.maps.Service.Status.OK) {
              return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
          }
          var result = response.result;
          
          var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
          /* alert(myaddr); */
          map.setCenter(myaddr); // 검색된 좌표로 지도 이동
          // 마커 표시
          var marker = new naver.maps.Marker({
             
            position: myaddr,
            icon: {
                 content: '<div style="width:100px;"><img src="http://static.naver.net/maps/v3/pin_default.png" alt="" ' +
                'style="margin: 0; padding: 0; border: 0 solid transparent; display: red; max-width: none; ' +
                'max-height: none; -webkit-user-select: none; position: absolute; width: 22px; height: 35px; left: 0; top: 0;"/>' +
                '<div style="position: absolute; top: 40px; left: -60px; color: darkcyan; font-weight: bold; font-size: 15px;">JSL인재개발원</div></div>',
                size: new naver.maps.Size(28, 37),
                anchor: new naver.maps.Point(11, 35) 
            },
            map: map
          });
          
          var url = new Array();	
          var address = new Array();		
          var markerOptions = new Array();	
          var markers = new Array();			
          
          var sizes = new naver.maps.Size(28, 37);
          var origins = new naver.maps.Point(0,0);
          var anchors = new naver.maps.Point(11, 35);
          
          
         /*  var cnt;
          cnt='<c:out value="${count}"/>'; 
          alert("cnt1값"+cnt); */
          //가게 위치 
          var j=0;
          <c:forEach var = "list" items = "${storedto}">
	        var x = ${list.latitude} 
	        var y = ${list.longitude}
	        address[j] = new naver.maps.LatLng(x,y);
	        j++;
          </c:forEach> 
          
          for(var i=0;i<j;i++) {

        	  /* alert("주소"+address[i]); */
        	 	url[i]='./image/'+i+'_spot.png';
        	  
        	  
        	  	markerOptions[i] = {
                   		position: address[i],
                  		 icon: {
                	   			url: url[i],
								size: sizes,
                        		origin : origins,
                       			anchor: anchors},
                 				map: map};
         		
         		 markers[i]= new naver.maps.Marker(markerOptions[i]);
          }
      
          
          
          var contentString = [
                               '<div class="iw_inner">',
                               '   <h3>서울특별시청</h3>',
                               '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br>',
                               '       <img src="./img/hot.jpg" width="55" height="55" alt="서울시청" class="thumb" /><br>',
                               '       02-120 | 공공,사회기관 > 특별,광역시청<br>',
                               '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
                               '   </p>',
                               '</div>'
                           ].join('');
       		// 마크 클릭시 인포윈도우 오픈
          var infowindow = new naver.maps.InfoWindow({
              /* content: '<h4>  다들 뭐하고 있어? </h4><a href="https://developers.naver.com" target="_blank"><img src="./img/hot.jpg"></a>' */
        	  content: contentString
          });
          
          // 마커 클릭 이벤트 처리
          naver.maps.Event.addListener(markers[0], "click", function(e) {
            if (infowindow.getMap()) {
                infowindow.close();
            } else {
               for(var i=0;i<cnt;i++){
                  infowindow.open(map, marker[i]);
                  
               }
            }
          });
          infowindow.open(map, marker[0]);
          
          
      });
      </script>
      
    </div>
  	
  	<%-- 
		int i=0; 
				
        <c:forEach var = "list" items = "${storedto}">
<!-- 	    <br> -->
	    <%System.out.print("i="+i); %>
	    <img src='./image/<%=i%>_spot.png'>
		        가게&nbsp;&nbsp;이름 = ${list.storeName} <br> 
		        가게&nbsp;&nbsp;주소 = ${list.address}<br>
		        가게&nbsp;&nbsp;번호 = ${list.storePhone}<br>
	      <%  i++;%>
        </c:forEach> 
         --%>
        
<!--     <div id="map" style="width:40%;height:700px;left:850px;top:0px;"></div> -->
    
   
      
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
   <!-- <img alt="" src="./img/0_spot.png"  onclick = "location.href = '../kFood.jsp' " >	한식 -->
</html>