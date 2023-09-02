package devmelonlee.delicious_place.controller;

import devmelonlee.delicious_place.dao.GatherDao;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component("gather/add")
public class GatherAddController implements PageController {
  GatherDao gatherDao;
  PlatformTransactionManager txManager;

  public GatherAddController(
          GatherDao gatherDao,
          PlatformTransactionManager txManager) {
    this.gatherDao = gatherDao;
    this.txManager = txManager;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return "/WEB-INF/jsp/gather/form.jsp";
    }
    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      request.getParts(); // 일단 클라이언트가 보낸 파일을 읽는다. 그래야 응답 가능!
      return "redirect:../auth/login";
    }

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus status = txManager.getTransaction(def);

    try {
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

      Date parsedDate = sdf.parse(appointmentTimeInput);
      Timestamp appointmentTime = new Timestamp(parsedDate.getTime());
      g.setAppointmentTime(appointmentTime);

      gatherDao.insert(g);
      txManager.commit(status);
      return "redirect:list";

    } catch (Exception e) {
      txManager.rollback(status);
      request.setAttribute("message", "게시글 등록 오류 입니다");
      request.setAttribute("refresh", "2;url=list");
      throw e;
    }
  }
}
