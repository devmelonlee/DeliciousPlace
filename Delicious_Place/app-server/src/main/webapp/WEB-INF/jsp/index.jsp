<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"%>

<%@ page import="devmelonlee.config.NaverMapsConfig" %>

<%
    NaverMapsConfig naverMapsConfig = (NaverMapsConfig) application.getAttribute("naverMapsConfig");
    String clientId = naverMapsConfig.getClientId();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>

<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
  <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=<%= clientId %>"></script>
<title> 🍔 딜리셔스 플레이스 - 메인 🍣 ️</title>
</head>

<style>
    h1 {
      text-align: center;
      padding: 50px;
    }

    div {
      text-align: center;
      padding: 30px;
    }

    .button {
      background-color: #DDD;
      border: none;
      color: black;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      margin: 4px 2px;
      cursor: pointer;
      border-radius: 16px;
    }

    .center {
      margin-left: auto;
      margin-right: auto;
    }
    main-title { background-color: #58ACFA; color: white; padding: 10px; margin: 0; }
  </style>

</head>
<body>
  <h1 class='main-title'>딜리셔스 플레이스</h1>
  <div>
    <button class="button" type="button" onclick="location.href='/content/list.jsp'">맛집리뷰</button>
    <button class="button" type="button" onclick="location.href='/gather/list'">같이 먹으러가요 - 게더</button>

    <jsp:useBean id="loginUser" class="devmelonlee.delicious_place.vo.User" scope="session"/>

    <% if (loginUser.getId() == 0) { %>
        <button class="button" type="button" onclick="location.href='/auth/form.jsp'">로그인</button>
        <button class="button" type="button" onclick="location.href='/auth/form.jsp'">회원 가입하러가기</button>
    <% } else {
            if (loginUser != null){ %>
                <img style='height:40px' src='/images/avatar.png'>
                ${loginUser.email} 님 안녕하세요
                <button class="button" type="button" onclick="location.href='/auth/logout.jsp'">로그아웃</button>
            <% } else { %>

            <% } %>
    <% } %>

  </div>
  <div id="map" style="width: 100%; height: 400px;"></div>
  <script>
    function init() {
      window.navigator.geolocation.getCurrentPosition(current_position);
    }

    function current_position(position) {
      var latitude = position.coords.latitude;
      var longitude = position.coords.longitude;
      var mapOptions = {
        center: new naver.maps.LatLng(latitude, longitude),
        zoom: 16,
        zoomControl: true
      };
      var map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(latitude, longitude),
        zoom: 16
      });
    }

    window.addEventListener("load", init);
    window.navermap_authFailure = function () {
      // 인증 실패 시 처리 코드 작성
      // ...
    };
  </script>
</body>
</html>

