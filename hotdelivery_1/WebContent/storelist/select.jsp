<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="delivery.store.dto.FoodDTO" %>
<%@ page import="delivery.store.dto.StoreDTO" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
      <title>早くて美味し過ぎる食べ物の注文はHOT Delivery！</title>
      <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=UqVySwksr8nrfXzw7enb&submodules=geocoder"></script>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/order.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/order.js"></script>
   
  </head>
  <body>
  <%-- <form action = "<c:out value="${pageContext.request.contextPath}"></c:out>/Address.do" method="post"> --%>
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
            <a href="<c:out value="${pageContext.request.contextPath}"></c:out>/cart/cart.jsp">注文のリスト</a>
            <div class="search">
               <form action = "../StoreSearchServlet" method="post">
                  <input type="text" name="search" placeholder="小さいジャンルから探す　ex)牛丼">
                  <input type="submit" value="探す">
               </form>
            </div>
         </div>
      </div>
   
    
    <div class="order_frame">
      <div class="a">
        <div class="Slides">
          <div class="head">
               数量設定
           </div>
          
          
          <div class="content">
            <div class="content_logo_map">
              <div class="img">
              <c:forEach var = "list" items = "${store}">
             
                <img src='<c:out value = "${list.imgUrl }"/>' >
                </c:forEach>
              </div>
              
            </div>
            
           <div class="content_menu">
              <form action ="Address.do" method = "post">
                  <c:forEach var = "store" items = "${store}">
                    <div class="restaurantname"> ${store.storeName}</div>
             </c:forEach>
         
            <div class="foodselect">
                     <span class="foodname">
                      <c:out value ="${fdto.get(0).foodName}"/>
                     </span>
                     <span class="many">
                       <input type="number" class="plus_minus" name="cnt0" value ="0" min="0" max="20">個

                     </span>
                     <span class="price"><c:out value ="${fdto.get(0).price}"/>ウォン</span>
                </div>
                <div class="foodselect">
                     <span class="foodname">
                       <c:out value ="${fdto.get(1).foodName}"/>
                     </span>
                     
                     <span class="many">
                       <input type="number" class="plus_minus" name="cnt1" value = "0"  min="0" max="20">個

                     </span>
                     <span class="price"><c:out value ="${fdto.get(1).price}"/>ウォン</span>
                 </div>
                 <div class="foodselect">
                     <span class="foodname">
                       <c:out value ="${fdto.get(2).foodName}"/>
                     </span>
                     <span class="many">
                       <input type="number" class="plus_minus" name="cnt2"  value = "0" min="0" max="20">個

                     </span>
                     <span class="price"><c:out value ="${fdto.get(2).price}"/>ウォン</span>
                 </div>
                 <div class="foodselect">
                     <span class="foodname">
                       <c:out value ="${fdto.get(3).foodName}"/>
                     </span>
                     <span class="many">
                       <input type="number" class="plus_minus" name="cnt3" value = "0"min="0" max="20">個
                       
                     </span>
                     <span class="price"><c:out value ="${fdto.get(3).price}"/>ウォン</span>
                 </div>
                  <div class="allpay">
                      <div>お支払い金額 - <%=session.getAttribute("sum")%></div>
                       <input type="submit" value ="リストに入れる">
                   </div>
             </form>
                  
                
           </div>
           
         </div>
      </div>
                   
      <div class="Slides">
         <div class="head">
             お届け先エリアを設定
          </div>

             <!-- 배달지설정 -->

          <div class="add_content">
            <div class="add_div">
             <form action = "Address1.do" method ="post">
              <div class="add_select_div">
                <span>お届け先エリアの選択方法</span><br><br> 
                <input type="radio" name="addselect" value="<c:out value ='${session.getParameter(addr) }'/>">直接入力<br>
                <span>エリア : </span><input type="text" name="inputAddr">
              </div>
              <br>
              <div class="add_select_div">
                  <input type="radio" name="addselect" value="<c:out value ='${sessionScope.dto.address }'/>">登録したエリア : 
                  <input type="text" name="output" id="add_input" value="대전광역시 중구 용두동 35-13 희영빌딩 5층">
                  <input type = "submit" value ="결제이동페이지이동">   
              </div>  
             </form>
            </div>
            
            <div class="map_location">
                <fieldset>
                  <legend>お店のエリア</legend>
                  <div id="map" style="width:100%;height:250px;left:0px;top:0px;"></div>
                  <script>
                  var myaddress=null;
                  var map = new naver.maps.Map('map');
                  map.setZoom(8);   //줌
                  <c:forEach var = "list" items = "${store}">
               // 도로명 주소나 지번 주소만 가능
              /*  alert('${list.address}'); */
                 var myaddress = '${list.address}';
                    </c:forEach> 
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
                            '<div style="position: absolute; top: 40px; left: -60px; color: darkcyan; font-weight: bold; font-size: 15px;"></div></div>',
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
                      <c:forEach var = "list" items = "${store}">
                       var x = ${list.latitude} 
                       var y = ${list.longitude}
                    /*    var z = '${list.address}' */
                      
                     /*   alert(z);  */
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
                      
                  
                      
                      var contentString = [
                                           '<div class="iw_inner">',
                                           '   <h3><c:out value ="${store.get(0).storeName}"/></h3>',
                                           '   <p style="font-size:0.8em;"><c:out value ="${store.get(0).address}"/><br>',
                                           '      <c:out value ="${store.get(0).storePhone}"/><br>',
                                           'sponsor : 스에나가마유코末永麻由子<br>',
                                           '       <a href="http://www.jslhrd.com/" target="_blank">www.jslhrd.com/</a>',
                                           '   </p>',
                                           '</div>'
                                       ].join('');
                      }
                         // 마크 클릭시 인포윈도우 오픈
                      var infowindow = new naver.maps.InfoWindow({
                          /* content: '<h4>  다들 뭐하고 있어? </h4><a href="https://developers.naver.com" target="_blank"><img src="./img/hot.jpg"></a>' */
                         content: contentString
                         
                        /*  maxWidth: 140,
                           backgroundColor: "#eee",
                           borderColor: "#2db400",
                           borderWidth: 5,
                           anchorSize: new naver.maps.Size(30, 30),
                           anchorSkew: true,
                           anchorColor: "#eee",

                           pixelOffset: new naver.maps.Point(20, -20) */
                      });
                      
                      // 마커 클릭 이벤트 처리
                      naver.maps.Event.addListener(marker, "click", function(e) {
                        if (infowindow.getMap()) {
                           /* alert(1); */
                            infowindow.close();
                        } else {
                              /* alert(2); */
                              infowindow.open(map, marker);
                        }
                      });
                      /*  infowindow.open(map, marker);  */
                      
                      
                  });
                  </script> 

                </fieldset>
              </div>
              
              
          </div>
         </div>
        <!-- <div class="Slides">
          <div class="head">
              お払い
          </div>
          <div class="content">
          
            <p>お支払い金額は 5000ウォン です</p><br>
            <p>お支払いしますか？</p>

            <div class="pay_button">
              <input type="submit" value="결제" data-needpopup-show="#id_search">
              <input type="button" value="취소" onclick="JavaScript:history.back(-1);">
            </div>
          </div>
        </div> -->
      </div>
      
      <button onclick="plusDivs(-1)"class="pre" >◁</button>
      <button onclick="plusDivs(1)"class="next" >▷</button>
  
    </div>

   <!-- <div id='id_search' class="needpopup">
              <a href="" class="needpopup_remover" onclick="cancel()">x</a>
              <div class="pay_top">
                <img src="../image/payco.png" alt="payco" width="88px" height="24px">
                <div class="pay_top_menu">
                  <div>
                    | 결제
                  </div>
                </div>
              </div>

              <div class="pay_main">
                <div class="header">정보확인</div>
                <table>
                  <tr>
                    <td class="td_name">결제금액</td>
                    <td><input type="text" id="summoney_input" name="summoney" value=""/></td>
                  </tr>
                  <tr>
                    <td class="td_name">이름</td>
                    <td><input type="text" id="name_input" name="name" value=""/></td>
                  </tr>
                  <tr>
                    <td class="td_name">이메일</td>
                    <td><input type="text" id="email_input" name="email" value=""/></td>
                  </tr>
                  <tr>
                    <td class="td_name">핸드폰</td>
                    <td><input type="text" name="phone"/></td>
                  </tr>
                  <tr>
                    <td><input type="button" value="휴대폰인증" onclick=""></td>
                    <td><input type="text" name="phonecheck"></td>
                  </tr>
                </table>

                <input type="submit" value="payment" onclick="payment_ok()">
       </div>
    </div> -->

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