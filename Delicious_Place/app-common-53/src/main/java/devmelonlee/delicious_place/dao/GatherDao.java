package devmelonlee.delicious_place.dao;

import java.util.List;
import devmelonlee.delicious_place.vo.Gather;

public interface GatherDao {

  void insert(Gather gather);

  List<Gather> list();

  Gather findBy(int no);

  Gather findByEmailAndPassword(Gather g);

  int update(Gather gather);

  int delete(int no);
}
