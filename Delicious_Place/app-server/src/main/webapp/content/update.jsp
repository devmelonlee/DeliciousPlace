<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="devmelonlee.delicious_place.vo.Content"%>

<jsp:useBean id="contentDao" type="devmelonlee.delicious_place.dao.ContentDao" scope="application"/>
<jsp:useBean id="sqlSessionFactory" type="org.apache.ibatis.session.SqlSessionFactory" scope="application"/>
<jsp:useBean id="loginUser" class="devmelonlee.delicious_place.vo.User" scope="session"/>

<%
    if (loginUser.getId() == 0) {
      response.sendRedirect("/auth/form.jsp");
      return;
    }

    request.setAttribute("refresh", "2;url=list.jsp");

    Content content = new Content();
    content.setContentId(Integer.parseInt(request.getParameter("id")));
    content.setStoreName(request.getParameter("storeName"));
    content.setContents(request.getParameter("contents"));
    content.setEatMenu(request.getParameter("eatMenu"));
    content.setHasReceipt(Integer.parseInt(request.getParameter("hasReceipt")));
    content.setStarRating(Integer.parseInt(request.getParameter("starRating")));
    content.setAuthor(loginUser);

    if (contentDao.update(content) == 0) {
            throw new Exception("찾는 리뷰가 없거나 수정할 권한이 없습니다.");
    } else {
        sqlSessionFactory.openSession(false).commit();
        response.sendRedirect("list.jsp");
    }
%>