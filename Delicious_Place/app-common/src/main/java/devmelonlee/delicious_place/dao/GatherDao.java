package devmelonlee.delicious_place.dao;

import java.util.List;
import devmelonlee.delicious_place.vo.Gather;

public interface GatherDao {

  void insert(Gather gather);

  List<Gather> findAll();

  Gather findBy(int id);

  int update(Gather gather);

  int updateAttendees(Gather gather);

  int delete(Gather gather);

}
