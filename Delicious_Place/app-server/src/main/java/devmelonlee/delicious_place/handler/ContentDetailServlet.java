package devmelonlee.delicious_place.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.vo.Content;

@WebServlet("/content/detail")
public class ContentDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Content content =
        InitServlet.contentDao.findBy(Integer.parseInt(request.getParameter("contentId")));

    response.setContentType("text/html;charset=UTF-8");
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
    out.println("<title>딜리셔스플레이스 - 리뷰 상세 보기</title>");
    out.println("</head>");

    // 리뷰 상세 조회

    out.println("<body>");
    out.println("<h1>리뷰 상세 보기</h1>");
    if (content == null) {
      out.println("<p>해당 번호의 게시글이 없습니다!</p>");

    } else {
      out.println("<form action='/content/update' method='post'>");
      out.printf("<input type='hidden' name='category'>\n");
      out.println("<table border='1' style='margin: 0 auto;'>");
      out.printf("<tr><th style='width:120px;'>번호</th>"
          + " <td style='width:300px;'><input type='text' name='id' value='%d' readonly></td></tr>\n",
          content.getContentId());
      out.printf(
          "<tr><th>음식점 이름</th>"
              + " <td><input type='text' name='storeName' value='%s'></td></tr>\n",
          content.getStoreName());
      out.printf("<tr><th>내용</th>"
          + " <td><textarea name='contents' style='height:200px; width:400px;'>%s</textarea></td></tr>\n",
          content.getContents());
      out.printf(
          "<tr><th>먹은메뉴</th>" + " <td><input type='text' name='eatMenu' value='%s'></td></tr>\n",
          content.getEatMenu());
      out.printf("<tr>\n" + "  <th>영수증 여부</th> <td>\n" + "   <select name=\"hasReceipt\">\n"
          + "      <option value=1>있음</option>\n" + "      <option value=0>없음</option>\n"
          + "    </select>  \n" + "  </td>\n" + "</tr>\n", content.getHasReceipt());
      out.printf(
          "<tr><th>별점</th> <td><select name=\"starRating\">\n"
              + "      <option value=5>⭐⭐⭐⭐⭐</option>\n" + "      <option value=4>⭐⭐⭐⭐</option>\n"
              + "      <option value=3>⭐⭐⭐</option>\n" + "      <option value=2>⭐⭐</option>\n"
              + "      <option value=1>⭐️</option>\n" + "    </select>  </td></tr>\n",
          content.getStarRating());
      out.printf(
          "<tr><th>작성자</th> <td><input type='text' name='email' value='%s' readonly></td></tr>\n",
          content.getAuthor().getEmail());
      out.printf(
          "<tr><th>성별</th> <td><input type='text' name='gender' value='%s' readonly></td></tr>\n",
          content.getAuthor().getGender());
      out.printf(
          "<tr><th>좋아요</th> <td><input type='text' name='likeButton' value='%d' readonly></td></tr>\n",
          content.getLikeButton());
      out.printf(
          "<tr><th>조회수</th> <td><input type='text' name='viewCount' value='%d' readonly></td></tr>\n",
          content.getViewCount());
      out.printf("<tr><th>등록일</th> <td>%tY-%1$tm-%1$td</td></tr>\n", content.getCreatedAt());
      out.println("</table>");

      // 하단 버튼부분
      out.println("<div>");
      out.println(
          "<button class='button' type= button onclick=\"location.href ='/content/list'\"> &lt; 목록으로</button>");
      out.println("<button class='button'>수정하기</button>");
      out.println("<button class='button' type='reset'>초기화</button>");
      out.printf(
          "<button class='button' type='button' onclick=\"location.href='/content/delete?contentId=%d'\">삭제하기</button>",
          content.getContentId());
      out.println("</div>");
      out.println("</form>");

      try {
        content.setViewCount(content.getViewCount() + 1);
        InitServlet.contentDao.updateCount(content);
        InitServlet.sqlSessionFactory.openSession(false).commit();

      } catch (Exception e) {
        InitServlet.sqlSessionFactory.openSession(false).rollback();
      }
    }

    out.println("</body>");
    out.println("</html>");

  }

}
