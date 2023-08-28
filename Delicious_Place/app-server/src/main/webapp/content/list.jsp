<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="devmelonlee.delicious_place.vo.Content"%>

<%
    request.setAttribute("refresh", "2;url=list.jsp");
%>

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
    <div class="container">
        <h1>맛집 리뷰 게시판</h1>
        <div style="margin:20px;">
            <button class="button" type="button" onclick="location.href = '/'">&lt; 메인</button>
            <button class="button" type="button" onclick="location.href = '/content/form.jsp'">✏️ 리뷰 추가</button>
        </div>
        <div class="center">
            <table border="1" style="margin: 0 auto;">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>음식점 이름</th>
                        <th>내용</th>
                        <th>작성자</th>
                        <th>성별</th>
                        <th>조회수</th>
                        <th>평점</th>
                        <th>좋아요</th>
                        <th>등록일</th>
                    </tr>
                </thead>

                <jsp:useBean id="contentDao" type="devmelonlee.delicious_place.dao.ContentDao"
                scope="application"/>

                <%
                    List<Content> list = contentDao.findAll();
                %>
                <tbody>
                <%
                    for (Content content : list) {
                        pageContext.setAttribute("content", content);

                %>
                    <tr>
                        <td>${content.contentId}</td>
                        <td>${content.storeName}</td>
                        <td><a href='/content/detail.jsp?contentId=${content.contentId}'>${content.contents}</a></td>
                        <td>${content.author.email}</td>
                        <td>${content.author.gender}</td>
                        <td>${content.viewCount}</td>
                        <td>${content.starRating}</td>
                        <td>${content.likeButton}</td>
                        <td>${simpleDateFormatter.format(content.createdAt)}</td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
