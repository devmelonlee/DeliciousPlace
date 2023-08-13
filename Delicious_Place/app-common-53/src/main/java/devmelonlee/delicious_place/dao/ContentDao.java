package devmelonlee.delicious_place.dao;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;

public interface ContentDao {

  void insert(Content content);

  List<Content> list();

  Content findBy(int no);

  int update(Content content);

  int delete(Content content);

}
