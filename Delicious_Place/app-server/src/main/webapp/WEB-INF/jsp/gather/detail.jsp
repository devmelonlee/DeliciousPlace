<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게더 글 보기</title>
    <style>
        h1, div {
            text-align: center;
        }
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
<h1>게더 글 보기</h1>

<c:choose>
    <c:when test="${g == null}">
        <p>해당 번호의 게시글이 없습니다!</p>
    </c:when>
    <c:otherwise>
        <form action="update" method="post">
            <table border="1" style="margin: 0 auto;">
                <tr>
                    <th style="width:120px;">번호</th>
                    <td style="width:300px;"><input type="text" name="id" value="${g.postId}" readonly></td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="postName" value="${g.postName}"></td>
                </tr>
                <tr>
                    <th>음식점 이름</th>
                    <td><input type="text" name="storeName" value="${g.storeName}"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" style="height:200px; width:400px;">${g.content}</textarea></td>
                </tr>
                <tr>
                    <th>현재인원</th>
                    <td><input type="text" name="currentAttendees" value="${g.currentAttendees}"></td>
                </tr>
                <tr>
                    <th>전체인원</th>
                    <td><input type="text" name="desiredAttendees" value="${g.desiredAttendees}"></td>
                </tr>
                <tr>
                    <th>약속 날짜와 시간</th>
                    <td><input type="datetime-local" name="appointmentTime" value="${g.appointmentTime}"></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="email" value="${g.author.email}" readonly></td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td><input type="text" name="gender" value="${g.author.gender}" readonly></td>
                </tr>
            </table>
            <div>
                <button class="button" type="button" onclick="location.href='/gather/list'">&lt; 목록으로</button>
                <button class="button">수정하기</button>
                <button class="button" type="reset">초기화</button>
                <button class="button" type="button" onclick="location.href='/gather/delete?postId=${g.postId}'">삭제하기</button>
            </div>
        </form>

        <!-- 댓글 기능 구현 부분 -->
        <c:set var="listCmt" value="${InitServlet.gatherCmtDao.findAll(findBy)}" />
        <c:set var="dateFormatter" value="MM-dd HH:mm" />
        <h3>댓글 <c:out value="${fn:length(listCmt)}" />개</h3>
        <hr />

        <div class="center">
            <table border="1" style="margin: 0 auto;">
                <thead>
                    <tr>
                        <th>작성자</th>
                        <th>내용</th>
                        <th>등록일</th>
                        <th>수정</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <c:forEach var="cmt" items="${listCmt}">
                    <tr>
                        <td><c:out value="${cmt.author.email}" /></td>
                        <td><c:out value="${cmt.content}" /></td>
                        <td><c:out value="${dateFormatter.format(cmt.createdAt)}" /></td>
                        <td><a href="/gatherCmt/update?commentId=<c:out value="${cmt.commentId}" />">수정</a></td>
                        <td><a href="/gatherCmt/delete?commentId=<c:out value="${cmt.commentId}" />">삭제</a></td>
                    </tr>
                </c:forEach>
            </table>
            <table border="1" style="margin: 20px auto;">
                <tr>
                    <td>댓글달기</td>
                    <td><input type="text" name="content"></td>
                    <td><button id="updateAttendees">확인 및 참가신청</button></td>
                </tr>
            </table>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
