package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.User;

@WebServlet("/gather/delete")
public class GatherDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");

    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.jsp");
      return;
    }

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/gather/list'>");
    out.println("<title>게더 게시글 삭제</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게더 게시글 삭제</h1>");

    Gather g = new Gather();

    g.setPostId(Integer.parseInt(request.getParameter("postId")));
    g.setAuthor(loginUser);

    try {
      if (InitServlet.gatherDao.delete(g) == 0) {
        out.println("<p>해당 번호의 게시글이 없거나 삭제 권한이 없습니다.</p>");
      } else {
        InitServlet.sqlSessionFactory.openSession(false).commit();
        out.println("<script>");
        out.println("alert(\"삭제되었습니다! \")");
        out.println("</script>");
        out.println("<meta http-equiv='refresh' content='1;url=/gather/list'>");
        response.sendRedirect("/gather/list");
      }

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>삭제 실패입니다!</p>");
      e.printStackTrace();
    }
  }



}
