package devmelonlee.delicious_place.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import devmelonlee.delicious_place.vo.User;

public class MySQLUserDao implements UserDao {

  SqlSessionFactory sqlSessionFactory;
  private final String NAMESPACE = "devmelonlee.delicious_place.dao.UserDao.";

  public MySQLUserDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insertUser(User user) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert(NAMESPACE + "insert", user);
  }

  @Override
  public int updateUser(User user) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update(NAMESPACE + "updateUser", user);
  }

  @Override
  public User getUserById(int userId) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne(NAMESPACE + "getUserById", userId);
  }

  @Override
  public String getUserByEmail(String email) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne(NAMESPACE + "getUserByEmail", email);
  }

  @Override
  public User getUserByEmailAndPassword(User user) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne(NAMESPACE + "getUserByEmailAndPassword", user);
  }



}
