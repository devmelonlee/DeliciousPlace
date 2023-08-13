package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Content;

@WebServlet("/content/list")
public class ContentListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();


    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<div class=\"container\">");

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
    out.println("<title>딜리셔스 플레이스 - 리뷰 목록</title>");
    out.println("</head>");

    out.println("<body>");
    out.println("<h1>맛집 리뷰 게시판</h1>");
    out.println("<div style='margin:20px;'>");
    out.println(
        "<button class= button type= button onclick=\"location.href ='/'\"> &lt; 메인</button>");
    out.println(
        "<button class= button type= button onclick=\"location.href ='/content/form.html'\"> ✏️ 리뷰 추가</button>");
    out.println("</div>");

    out.println("<div class='center'>");
    out.println("<table border='1' style='margin: 0 auto;'>");
    out.println("<thead>");
    out.println(
        "  <tr><th>번호</th> <th>음식점 이름</th> <th>내용</th> <th>작성자</th><th>성별</th><th>조회수</th><th>평점</th><th>좋아요</th><th>등록일</th></tr>");
    out.println("</thead>");

    List<Content> list = InitServlet.contentDao.findAll();
    for (Content c : list) {
      out.printf("<tr>" + " <td><a href='/content/detail?contentId=%d'>%d</a></td>"
          + " <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%d</td> <td>%d</td> <td>%d</td> <td>%s</td> </tr>\n",
          c.getContentId(), c.getContentId(), c.getStoreName(), c.getContents(),
          c.getAuthor().getEmail(), c.getAuthor().getGender(), c.getViewCount(), c.getStarRating(),
          c.getLikeButton(), dateFormatter.format(c.getCreatedAt()));
    }

    out.println("</tbody>");
    out.println("</table>");
    out.println("</body>");

    out.println("</div>");
    out.println("</html>");
  }
}
