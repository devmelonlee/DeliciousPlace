package devmelonlee.delicious_place.dao;

import java.util.List;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.GatherCmt;

public interface GatherCmtDao {

  void insert(GatherCmt gatherCmt);

  List<GatherCmt> findAll(int id);

  Gather findBy(int id); // 추후

  int update(GatherCmt gatherCmt); // 추후

  int delete(GatherCmt gatherCmt); // 추후
}
