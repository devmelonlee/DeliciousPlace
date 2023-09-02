package devmelonlee.delicious_place.controller;


import devmelonlee.delicious_place.dao.GatherDao;
import devmelonlee.delicious_place.vo.Gather;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("gather/list")
public class GatherListServlet implements PageController {
  GatherDao gatherDao;

  public GatherListServlet(GatherDao gatherDao) {
    this.gatherDao = gatherDao;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setAttribute("list", gatherDao.findAll());
    return "/WEB-INF/jsp/gather/list.jsp";
  }
}
