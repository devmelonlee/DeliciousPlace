package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.User;

@WebServlet("/gather/add")
public class GatherAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");


    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.jsp");
      return;
    }
    Gather g = new Gather();
    g.setPostName(request.getParameter("postName"));
    g.setStoreName(request.getParameter("storeName"));
    g.setContent(request.getParameter("content"));
    g.setDesiredAttendees(Integer.parseInt(request.getParameter("desiredAttendees")));
    g.setCurrentAttendees(1);

    // 약속한 시간 받아온다.
    String appointmentTimeInput = request.getParameter("appointmentTime");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    g.setAuthor(loginUser);
    g.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/gather/list'>");
    out.println("<title>딜리셔스 플레이스 - 게더 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게더 등록</h1>");

    try {
      // 약속한 시간 처리하는 코
      Date parsedDate = sdf.parse(appointmentTimeInput);
      Timestamp appointmentTime = new Timestamp(parsedDate.getTime());
      g.setAppointmentTime(appointmentTime);


      InitServlet.gatherDao.insert(g);
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
