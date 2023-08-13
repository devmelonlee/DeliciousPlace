package devmelonlee.delicious_place.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import devmelonlee.delicious_place.vo.Gather;

public class MySQLGatherDao implements GatherDao {

  SqlSessionFactory sqlSessionFactory;
  private final String NAMESPACE = "devmelonlee.delicious_place.dao.GatherDao.";

  public MySQLGatherDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Gather gather) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert(NAMESPACE + "insert", gather);
  }

  @Override
  public List<Gather> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList(NAMESPACE + "findAll");
  }

  @Override
  public Gather findBy(int id) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne(NAMESPACE + "findBy", id);
  }

  @Override
  public int update(Gather gather) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update(NAMESPACE + "update", gather);
  }

  @Override
  public int updateAttendees(Gather gather) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update(NAMESPACE + "updateAttendees", gather);
  }

  @Override
  public int delete(Gather gather) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete(NAMESPACE + "delete", gather);
  }

}
