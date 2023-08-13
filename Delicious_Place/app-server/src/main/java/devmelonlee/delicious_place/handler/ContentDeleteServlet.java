package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.delicious_place.vo.User;

@WebServlet("/content/delete")
public class ContentDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/content/list'>");
    out.println("<title>리뷰 삭제</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>리뷰 삭제</h1>");


    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>삭제 권한이 없습니다!</p>");
      response.sendRedirect("/auth/form.html");
      return;
    }

    Content content = new Content();
    content.setContentId(Integer.parseInt(request.getParameter("contentId")));
    content.setAuthor(loginUser);

    try {
      if (InitServlet.contentDao.delete(content) == 0) {
        out.println("<p>해당 번호의 리뷰가 없거나 삭제 권한이 없습니다.</p>");
      } else {
        InitServlet.sqlSessionFactory.openSession(false).commit();
        out.println("<meta http-equiv='refresh' content='1;url=/content/list'>");
        out.println("<p>삭제 되었습니다!</p>");
        response.sendRedirect("/content/list");
      }

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>삭제 실패입니다!</p>");
      e.printStackTrace();
    }
  }

}
