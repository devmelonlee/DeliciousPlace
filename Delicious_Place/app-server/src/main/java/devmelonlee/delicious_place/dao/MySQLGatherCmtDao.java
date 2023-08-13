package devmelonlee.delicious_place.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import devmelonlee.delicious_place.vo.Gather;
import devmelonlee.delicious_place.vo.GatherCmt;

public class MySQLGatherCmtDao implements GatherCmtDao {
  SqlSessionFactory sqlSessionFactory;
  private final String NAMESPACE = "devmelonlee.delicious_place.dao.GatherCmtDao.";

  public MySQLGatherCmtDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(GatherCmt gatherCmt) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert(NAMESPACE + "insert", gatherCmt);
  }

  @Override
  public List<GatherCmt> findAll(int id) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList(NAMESPACE + "findAll", id);
  }

  // 추후 구현
  @Override
  public Gather findBy(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(GatherCmt gatherCmt) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(GatherCmt gatherCmt) {
    // TODO Auto-generated method stub
    return 0;
  }

}
