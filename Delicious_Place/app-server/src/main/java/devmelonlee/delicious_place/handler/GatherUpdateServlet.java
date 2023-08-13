package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.User;

@WebServlet("/gather/update")
public class GatherUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.html");
      return;
    }

    Gather g = new Gather();
    g.setPostId(Integer.parseInt(request.getParameter("id")));
    g.setPostName(request.getParameter("postName"));
    g.setStoreName(request.getParameter("storeName"));
    g.setContent(request.getParameter("content"));
    g.setDesiredAttendees(Integer.parseInt(request.getParameter("desiredAttendees")));
    g.setAuthor(loginUser);

    // 약속한 시간 받아온다.
    String appointmentTimeInput = request.getParameter("appointmentTime");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/gather/list'>");
    out.println("<title>딜리셔스 플레이스 - 게더 수정</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게더 수정하기</h1>");

    try {
      // 약속한 시간 처리하는 코드
      Date parsedDate = sdf.parse(appointmentTimeInput);
      Timestamp appointmentTime = new Timestamp(parsedDate.getTime());
      g.setAppointmentTime(appointmentTime);

      if (InitServlet.gatherDao.update(g) == 0) {
        out.println("<p>찾는 게시글이 없거나 수정할 권한이 없습니다.</p>");
      } else {

        InitServlet.sqlSessionFactory.openSession(false).commit();
        out.println("<p>변경 했습니다!</p>");
      }
    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>수정 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");


  }

}
