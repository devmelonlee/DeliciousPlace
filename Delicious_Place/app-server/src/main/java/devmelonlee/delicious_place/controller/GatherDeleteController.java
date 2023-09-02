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

@Component("gather/delete")
public class GatherDeleteController implements PageController{

  GatherDao gatherDao;
  PlatformTransactionManager txManager;

  public GatherDeleteController(
          GatherDao gatherDao,
          PlatformTransactionManager txManager) {
    this.gatherDao = gatherDao;
    this.txManager = txManager;
  }


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    User loginUser = (User) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      return "redirect:../auth/login";
    }

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus status = txManager.getTransaction(def);

    try {
      Gather g = new Gather();

      g.setPostId(Integer.parseInt(request.getParameter("postId")));
      g.setAuthor(loginUser);

      if (gatherDao.delete(g) == 0) {
        throw new Exception("해당 번호의 게시글이 없거나 삭제 권한이 없습니다.");
      } else {
        txManager.commit(status);
        return "redirect:list";
      }

    } catch (Exception e) {
      txManager.rollback(status);
      request.setAttribute("refresh", "2;url=list");
      throw e;
    }
  }

}
