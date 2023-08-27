package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Content;
import devmelonlee.delicious_place.vo.User;


@WebServlet("/content/add")
public class ContentAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.jsp");
      return;
    }
    Content content = new Content();
    content.setStoreName(request.getParameter("storeName"));
    content.setContents(request.getParameter("contents"));
    content.setEatMenu(request.getParameter("eatMenu"));
    content.setHasReceipt(Integer.parseInt(request.getParameter("hasReceipt")));
    content.setStarRating(Integer.parseInt(request.getParameter("starRating")));
    content.setAuthor(loginUser);
    content.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/content/list'>");
    out.println("<title>음식 리뷰</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>리뷰 등록</h1>");
    try {
      InitServlet.contentDao.insert(content);
      InitServlet.sqlSessionFactory.openSession(false).commit();
      out.println("<p>등록 성공입니다!</p>");

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>등록 실패입니다!</p>");
      e.printStackTrace();
    }
    out.println("</body>");
    out.println("</html>");

  }

}
