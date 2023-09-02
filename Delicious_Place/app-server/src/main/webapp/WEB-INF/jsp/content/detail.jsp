<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ page import="devmelonlee.delicious_place.vo.Content"%>

<jsp:useBean id="contentDao" type="devmelonlee.delicious_place.dao.ContentDao" scope="application"/>
<jsp:useBean id="sqlSessionFactory" type="org.apache.ibatis.session.SqlSessionFactory" scope="application"/>

<%
    request.setAttribute("refresh", "2;url=list.jsp");
    Content content = contentDao.findBy(Integer.parseInt(request.getParameter("contentId")));
    pageContext.setAttribute("content", content);
%>

<!DOCTYPE html>
<html>
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
.center{
  margin-left: auto;
  margin-right: auto;
}
</style>
<head>
<meta charset='UTF-8'>
<title>딜리셔스플레이스 - 리뷰 상세 보기</title>
</head>

<h1>음식점 리뷰</h1>

<%
    if (content == null) {
%>
    <p>해당 번호의 리뷰를 찾을 수 없어요!</p>
<%
    } else {
%>

<form action='/content/update.jsp' method="post">
    <table border='1' style='margin: 0 auto;'>

        <tr>
            <th style='width:120px;'>번호</th>
            <td style='width:300px;'>
                <input type='text' name='id' value='${content.contentId}' readonly>
            </td>
        </tr>

        <tr>
            <th>음식점 이름</th>
            <td>
                <input type='text' name='storeName' value='${content.storeName}'>
            </td>
        </tr>

        <tr>
            <th>내용</th>
            <td>
                <textarea name='contents' style='height:200px; width:500px;'>${content.contents}</textarea>
            </td>
        </tr>

        <tr>
            <th>먹은메뉴</th>
            <td>
                <input type='text' name='eatMenu' value='${content.eatMenu}'>
            </td>
        </tr>

        <tr>
             <th>영수증 여부</th>
             <td>
                 <select name="hasReceipt">
                     <option value="1" ${content.hasReceipt == 1 ? "selected" : ""}>있음</option>
                     <option value="0" ${content.hasReceipt == 0 ? "selected" : ""}>없음</option>
                 </select>
             </td>
         </tr>

        <tr>
         <th>별점</th>
         <td>
             <select name="starRating">
                 <option value="5" ${content.starRating == 5 ? "selected" : ""}>⭐⭐⭐⭐⭐</option>
                 <option value="4" ${content.starRating == 4 ? "selected" : ""}>⭐⭐⭐⭐</option>
                 <option value="3" ${content.starRating == 3 ? "selected" : ""}>⭐⭐⭐</option>
                 <option value="2" ${content.starRating == 2 ? "selected" : ""}>⭐⭐</option>
                 <option value="1" ${content.starRating == 1 ? "selected" : ""}>⭐️</option>
             </select>
         </td>
        </tr>
         <tr>
             <th>작성자</th>
             <td><input type='text' name='email' value='${content.author.email}' readonly></td>
         </tr>

         <tr>
             <th>성별</th>
             <td><input type='text' name='gender' value='${content.author.gender}' readonly></td>
         </tr>

         <tr>
             <th>좋아요</th>
             <td><input type='text' name='likeButton' value='${content.likeButton}' readonly></td>
         </tr>

         <tr>
             <th>조회수</th>
             <td><input type='text' name='viewCount' value='${content.viewCount}' readonly></td>
         </tr>
         <tr>
            <th>등록일</th>
            <td>${simpleDateFormatter.format(content.createdAt)}</td>
         </tr>
<%
   }
%>
    </table>

<div>
    <button class='button' type='button' onclick="location.href='/content/list.jsp'">&lt; 목록으로</button>
    <button class='button'>수정하기</button>
    <button class='button' type='reset'>초기화</button>
    <button class='button' type='button' onclick="location.href='/content/delete.jsp?contentId=${content.contentId}'">삭제하기</button>
</div>
</form>

<%
      try {
        content.setViewCount(content.getViewCount() + 1);
        contentDao.updateCount(content);
        sqlSessionFactory.openSession(false).commit();

      } catch (Exception e) {
        sqlSessionFactory.openSession(false).rollback();
      }
%>

</body>
</html>