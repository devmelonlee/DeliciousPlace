package devmelonlee.delicious_place.handler;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.GatherCmt;
import devmelonlee.delicious_place.vo.User;


@WebServlet("/gather/detail")
public class GatherDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    int findBy = Integer.parseInt(request.getParameter("postId"));

    Gather g = InitServlet.gatherDao.findBy(findBy);
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");

    out.println("<style>");
    out.println("h1 {text-align: center;}");
    out.println("div {text-align: center;}");
    out.println(".button {");
    out.println("  background-color: #03c75a;");
    out.println("  border: none;");
    out.println("  color: white;");
    out.println("  padding: 10px 20px;");
    out.println("  text-align: center;");
    out.println("  text-decoration: none;");
    out.println("  display: inline-block;");
    out.println("  margin: 4px 2px;");
    out.println("  cursor: pointer;");
    out.println("  border-radius: 16px;");
    out.println("}");
    out.println(".center{");
    out.println("  margin-left: auto;");
    out.println("  margin-right: auto;");
    out.println("}");
    out.println("</style>");

    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게더 글 보기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게더 글 보기</h1>");

    if (g == null) {
      out.println("<p>해당 번호의 게시글이 없습니다!</p>");

    } else {
      out.println("<form action='/gather/update' method='post'>");
      out.println("<table border='1' style='margin: 0 auto;'>");
      out.printf("<tr><th style='width:120px;'>번호</th>"
          + " <td style='width:300px;'><input type='text' name='id' value='%d' readonly></td></tr>\n",
          g.getPostId());
      out.printf(
          "<tr><th>제목</th>" + " <td><input type='text' name='postName' value='%s'></td></tr>\n",
          g.getPostName());
      out.printf(
          "<tr><th>음식점 이름</th>"
              + " <td><input type='text' name='storeName' value='%s'></td></tr>\n",
          g.getStoreName());
      out.printf("<tr><th>내용</th>"
          + " <td><textarea name='content' style='height:200px; width:400px;'>%s</textarea></td></tr>\n",
          g.getContent());
      out.printf(
          "<tr><th>현재인원</th>"
              + " <td><input type='text' name='currentAttendees' value='%d'></td></tr>\n",
          g.getCurrentAttendees());
      out.printf(
          "<tr><th>전체인원</th>"
              + " <td><input type='text' name='desiredAttendees' value='%d'></td></tr>\n",
          g.getDesiredAttendees());
      out.printf(
          "<tr><th>약속 날짜와 시간</th>"
              + "<td><input type='datetime-local' name='appointmentTime' value='%s'></td></tr>\n",
          g.getAppointmentTime());

      out.printf(
          "<tr><th>작성자</th> <td><input type='text' name='email' value='%s' readonly></td></tr>\n",
          g.getAuthor().getEmail());
      out.printf(
          "<tr><th>성별</th> <td><input type='text' name='gender' value='%s' readonly></td></tr>\n",
          g.getAuthor().getGender());
      out.println("</table>");

      out.println("<div>");
      out.println(
          "<button class='button' type= button onclick=\"location.href ='/gather/list'\"> &lt; 목록으로</button>");
      out.println("<button class='button'>수정하기</button>");
      out.println("<button class='button' type='reset'>초기화</button>");
      out.printf(
          "<button class='button' type='button' onclick=\"location.href='/gather/delete?postId=%d'\">삭제하기</button>",
          g.getPostId());

      out.println("</div>");
      out.println("</form>");


      // 댓글 기능 구현 부분

      List<GatherCmt> listCmt = InitServlet.gatherCmtDao.findAll(findBy);
      SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd HH:mm");
      out.printf("<h3>댓글 %d개</h3>", listCmt.size());
      out.println("<hr>");


      out.println("<div class='center'>");
      out.println("<table border='1' style='margin: 0 auto;'>");
      out.println("<thead>");
      out.println("  <tr><th>작성자</th> <th>내용</th> <th>등록일</th> <th>수정</th> <th>삭제</th> </tr>");
      out.println("</thead>");

      // 댓글 테이블 부분(list)

      for (GatherCmt cmt : listCmt) {
        out.printf(
            "<tr> <td>%s</td> <td>%s</td> <td>%s</td> "
                + "<td><a href='/gatherCmt/update?commentId=%d'>수정</a></td> "
                + "<td><a href='/gatherCmt/delete?commentId=%d'>삭제</a></td></tr>\n",
            cmt.getAuthor().getEmail(), cmt.getContent(), dateFormatter.format(cmt.getCreatedAt()),
            cmt.getCommentId(), cmt.getCommentId());
      }

      // 댓글 작성 부분 (add)
      User loginUser = (User) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        response.sendRedirect("/auth/form.jsp");
        return;
      }

      GatherCmt cmtAdd = new GatherCmt();
      cmtAdd.setPostId(findBy);
      cmtAdd.setAuthor(loginUser);
      cmtAdd.setContent(request.getParameter("content"));
      cmtAdd.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
      response.setContentType("text/html;charset=UTF-8");

      out.println("<table border='1' style='margin: 20px auto;'>");
      out.println("<tr><td>댓글달기</td> <td><input type='text' name='content' ></td>"
          + " <td><button id='updateAttendees'>확인 및 참가신청</button> </td> </tr>\n");
      out.println("</table>");
      out.println("</div>");


      try {
        InitServlet.sqlSessionFactory.openSession(false).commit();

      } catch (Exception e) {
        InitServlet.sqlSessionFactory.openSession(false).rollback();
      }
    }

    out.println("</body>");
    out.println("</html>");

  }

}
