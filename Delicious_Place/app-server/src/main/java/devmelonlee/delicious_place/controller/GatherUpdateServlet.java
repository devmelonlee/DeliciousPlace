package devmelonlee.delicious_place.controller;

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

import devmelonlee.delicious_place.dao.GatherDao;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("gather/update")
public class GatherUpdateServlet  implements PageController {

  GatherDao gatherDao;
  PlatformTransactionManager txManager;

  public GatherUpdateServlet(
          GatherDao gatherDao,
          PlatformTransactionManager txManager) {
    this.gatherDao = gatherDao;
    this.txManager = txManager;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus status = txManager.getTransaction(def);

    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      request.getParts(); // 일단 클라이언트가 보낸 파일을 읽는다. 그래야 응답 가능!
      return "redirect:../auth/login";
    }

    try {
      Gather g = new Gather();
      g.setPostId(Integer.parseInt(request.getParameter("id")));
      g.setPostName(request.getParameter("postName"));
      g.setStoreName(request.getParameter("storeName"));
      g.setContent(request.getParameter("content"));
      g.setDesiredAttendees(Integer.parseInt(request.getParameter("desiredAttendees")));
      g.setAuthor(loginUser);
      String appointmentTimeInput = request.getParameter("appointmentTime");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

      try {
        Date parsedDate = sdf.parse(appointmentTimeInput);
        Timestamp appointmentTime = new Timestamp(parsedDate.getTime());
        g.setAppointmentTime(appointmentTime);

        if (gatherDao.update(g) == 0) {
          throw new Exception("게시글이 없거나 변경 권한이 없습니다.");
        } else {
          txManager.commit(status);
          return "redirect:list";
        }
      } catch (Exception e) {
        txManager.rollback(status);
        request.setAttribute("refresh", "2;url=detail?id=" + request.getParameter("id"));
        throw e;
      }
    } catch (Exception e) {
      txManager.rollback(status);
      request.setAttribute("refresh", "2;url=detail?id=" + request.getParameter("id"));
      throw e;

    }
  }
}