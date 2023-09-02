package devmelonlee.delicious_place.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import devmelonlee.delicious_place.dao.GatherDao;
import org.springframework.stereotype.Component;

@Component("gather/detail")
public class GatherDetailServlet implements PageController {

  GatherDao gatherDao;

  public GatherDetailServlet(GatherDao gatherDao) {
    this.gatherDao = gatherDao;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setAttribute("g",
            gatherDao.findBy(Integer.parseInt(request.getParameter("postId"))));
    return "/WEB-INF/jsp/gather/detail.jsp";
  }

}
