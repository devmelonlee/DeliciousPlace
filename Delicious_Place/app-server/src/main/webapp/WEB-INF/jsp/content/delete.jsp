<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
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
    content.setContentId(Integer.parseInt(request.getParameter("contentId")));
    content.setAuthor(loginUser);

    if (contentDao.delete(content) == 0) {
       throw new Exception("해당 번호의 리뷰가 없거나 삭제 권한이 없습니다.");
    } else {
       sqlSessionFactory.openSession(false).commit();
       response.sendRedirect("list.jsp");
    }
%>