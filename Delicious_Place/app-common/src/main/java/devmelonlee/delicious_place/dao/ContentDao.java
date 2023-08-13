package devmelonlee.delicious_place.dao;

import java.util.List;
import devmelonlee.delicious_place.vo.Content;

public interface ContentDao {

  void insert(Content content);

  List<Content> findAll();

  Content findBy(int id);

  int update(Content content);

  int updateCount(Content content);

  int delete(Content content);

}
