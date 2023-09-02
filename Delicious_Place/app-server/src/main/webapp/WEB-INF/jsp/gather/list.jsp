<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>딜리셔스 플레이스 - 리뷰 목록</title>
    <style>
        h1 {text-align: center;}
        div {text-align: center;}
        .button {
            background-color: #03c75a;
            border: none;
            color: white;
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
    </style>
</head>
<body>

<h1>게더 - 같이 먹어요</h1>
<div style="margin: 20px;">
    <button class="button" type="button" onclick="location.href = '/'">&lt; 메인</button>
    <button class="button" type="button" onclick="location.href = '/gather/form.jsp'">✏️ 게더 만들기</button>
</div>

<table border="1" style="margin: 0 auto;">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>음식점</th>
            <th>현재인원</th>
            <th>전체인원</th>
            <th>약속시간</th>
            <th>작성자</th>
            <th>성별</th>
            <th>작성일시</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}"var="g" >
            <tr>
                <td><a href="/gather/detail?postId=${g.postId}">${g.postId}</a></td>
                <td>${g.postName}</td>
                <td>${g.storeName}</td>
                <td>${g.currentAttendees}</td>
                <td>${g.desiredAttendees}</td>
                <td>${g.appointmentTime}</td>
                <td>${g.author.email}</td>
                <td>${g.author.gender}</td>
                <td>${g.createdAt}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>