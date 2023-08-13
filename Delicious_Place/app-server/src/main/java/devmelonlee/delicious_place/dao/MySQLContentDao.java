package devmelonlee.delicious_place.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import devmelonlee.delicious_place.vo.Content;

public class MySQLContentDao implements ContentDao {

  SqlSessionFactory sqlSessionFactory;

  public MySQLContentDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Content content) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("devmelonlee.delicious_place.dao.ContentDao.insert", content);
  }

  @Override
  public List<Content> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList("devmelonlee.delicious_place.dao.ContentDao.findAll");
  }

  @Override
  public Content findBy(int id) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne("devmelonlee.delicious_place.dao.ContentDao.findBy", id);
  }

  @Override
  public int update(Content content) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("devmelonlee.delicious_place.dao.ContentDao.update", content);
  }

  @Override
  public int updateCount(Content content) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("devmelonlee.delicious_place.dao.ContentDao.updateCount", content);
  }

  @Override
  public int delete(Content content) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("devmelonlee.delicious_place.dao.ContentDao.delete", content);
  }

}
