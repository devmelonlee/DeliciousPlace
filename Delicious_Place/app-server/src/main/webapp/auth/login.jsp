<%@ page
    language="java"
    pageEncoding="UTF-8"
    contentType="text/html;charset=UTF-8"
    trimDirectiveWhitespaces="true"
    errorPage="/error.jsp"%>
<%@ page import="devmelonlee.delicious_place.dao.UserDao"%>
<%@ page import="devmelonlee.delicious_place.vo.User"%>

<%
    request.setAttribute("refresh", "2;url=/auth/form.jsp");

    User user = new User();
    user.setEmail(request.getParameter("email"));
    user.setPassword(request.getParameter("password"));

    if (request.getParameter("saveEmail") != null) {
      Cookie cookie = new Cookie("email", user.getEmail());
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "id");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
%>

<jsp:useBean id="userDao" type="devmelonlee.delicious_place.dao.UserDao" scope="application"/>

<%
    User loginUser = userDao.getUserByEmailAndPassword(user);
    if (loginUser == null) {
      throw new Exception("회원 정보가 일치하지 않습니다.");
    }

    session.setAttribute("loginUser", loginUser);
    response.sendRedirect("/");
%>
