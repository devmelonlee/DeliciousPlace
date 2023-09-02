package devmelonlee.delicious_place.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import devmelonlee.util.SqlSessionFactoryProxy;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

  public MyServletRequestListener() {
    System.out.println("MyServletRequestListener 객체 생성되었음!");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // ((SqlSessionFactoryProxy) InitServlet.sqlSessionFactory).clean();
//    SqlSessionFactoryProxy sqlSessionFactoryProxy = (SqlSessionFactoryProxy) sre.getServletContext().getAttribute("sqlSessionFactory");
//    sqlSessionFactoryProxy.clean();
  }
}
