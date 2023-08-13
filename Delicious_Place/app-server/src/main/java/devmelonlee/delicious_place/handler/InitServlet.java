package devmelonlee.delicious_place.handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import devmelonlee.delicious_place.dao.ContentDao;
import devmelonlee.delicious_place.dao.GatherDao;
import devmelonlee.delicious_place.dao.MySQLContentDao;
import devmelonlee.delicious_place.dao.MySQLGatherDao;
import devmelonlee.delicious_place.dao.MySQLUserDao;
import devmelonlee.delicious_place.dao.UserDao;
import devmelonlee.util.SqlSessionFactoryProxy;

@WebServlet(value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public static SqlSessionFactory sqlSessionFactory;
  public static UserDao userDao;
  public static ContentDao contentDao;
  public static GatherDao gatherDao;

  @Override
  public void init() throws ServletException {
    System.out.println("InitServlet.init() 호출됨!");

    try {
      sqlSessionFactory = new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder().build(
          Resources.getResourceAsStream("devmelonlee/delicious_place/config/mybatis-config.xml")));

      userDao = new MySQLUserDao(sqlSessionFactory);
      contentDao = new MySQLContentDao(sqlSessionFactory);
      gatherDao = new MySQLGatherDao(sqlSessionFactory);

    } catch (Exception e) {
      System.out.println("InitServlet.init() 실행 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
