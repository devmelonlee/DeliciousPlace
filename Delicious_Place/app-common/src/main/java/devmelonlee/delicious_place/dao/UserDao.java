package devmelonlee.delicious_place.dao;

import devmelonlee.delicious_place.vo.User;

public interface UserDao {

  void insertUser(User user);

  int updateUser(User user);

  User getUserById(int userId);

  String getUserByEmail(String email);

  User getUserByEmailAndPassword(User user);


}

